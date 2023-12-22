/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.Achievement;
import ru.urvanov.virtualpets.server.domain.AchievementCode;
import ru.urvanov.virtualpets.server.domain.Drink;
import ru.urvanov.virtualpets.server.domain.DrinkType;
import ru.urvanov.virtualpets.server.domain.FoodType;
import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;
import ru.urvanov.virtualpets.server.domain.Level;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetAchievement;
import ru.urvanov.virtualpets.server.domain.PetDrink;
import ru.urvanov.virtualpets.server.domain.PetFood;
import ru.urvanov.virtualpets.server.domain.PetJournalEntry;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.server.domain.User;
import ru.urvanov.virtualpets.shared.domain.CreatePetArg;
import ru.urvanov.virtualpets.shared.domain.CreatePetResult;
import ru.urvanov.virtualpets.shared.domain.DrinkArg;
import ru.urvanov.virtualpets.shared.domain.PetInfo;
import ru.urvanov.virtualpets.shared.domain.PetListResult;
import ru.urvanov.virtualpets.shared.domain.SatietyArg;
import ru.urvanov.virtualpets.shared.domain.SelectPetArg;
import ru.urvanov.virtualpets.shared.domain.SelectPetResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.PetService;


/**
 * @author fedya
 * 
 */
@Service(value = "petRemoting")
public class PetRemoting implements PetService {

    @Autowired
    private ru.urvanov.virtualpets.server.service.PetService petService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.UserService userService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.PetFoodService foodService;

    @Autowired
    private ConversionService conversionService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.DrinkService drinkService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.JournalEntryService journalEntryService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.AchievementService achievementService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.LevelService levelService;

    /**
     * 
     */
    public PetRemoting() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ru.urvanov.virtualpets.shared.service.PetService#getUserPets(ru.
     * urvanov.virtualpets.shared.domain.PetListArg)
     */
    @Override
    public PetListResult getUserPets() throws DaoException,
            ServiceException {
        org.springframework.web.context.request.ServletRequestAttributes sra = (org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder
                .getRequestAttributes();
        Object var1 = sra.getAttribute("my1",
                ServletRequestAttributes.SCOPE_SESSION);
        System.out.println("VAR1=" + var1);
        SecurityContext securityContext = (SecurityContext) SecurityContextHolder
                .getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Pet> pets = petService.findByUserId(user.getId());

        PetInfo[] petInfos;
        if (pets != null) {
            int length = pets.toArray().length;
            petInfos = new PetInfo[length];
            int n = 0;
            for (Pet p : pets) {
                petInfos[n] = new PetInfo();
                petInfos[n].setName(p.getName());
                petInfos[n].setId(p.getId());
                petInfos[n]
                        .setPetType(conversionService.convert(
                                p.getPetType(),
                                ru.urvanov.virtualpets.shared.domain.PetType.class));
                n++;
            }
        } else {
            petInfos = new PetInfo[0];
        }
        PetListResult result = new PetListResult();
        result.setSuccess(true);
        result.setPetsInfo(petInfos);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ru.urvanov.virtualpets.shared.service.PetService#create(ru.urvanov
     * .virtualpets.shared.domain.CreatePetArg)
     */
    @Override
    @Transactional
    public CreatePetResult create(CreatePetArg arg) throws DaoException,
            ServiceException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Pet pet = new Pet();
        pet.setName(arg.getName());
        pet.setCreatedDate(new Date());
        pet.setUser(userService.getReference(user.getId()));
        pet.setComment(arg.getComment());
        pet.setPetType(conversionService.convert(arg.getPetType(),
                ru.urvanov.virtualpets.server.domain.PetType.class));
        Level level = levelService.findById(1);
        pet.setLevel(level);
        petService.save(pet);
        CreatePetResult result = new CreatePetResult();
        result.setSuccess(true);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ru.urvanov.virtualpets.shared.service.PetService#select(ru.urvanov
     * .virtualpets.shared.domain.SelectPetArg)
     */
    @Override
    public SelectPetResult select(SelectPetArg arg) throws DaoException,
            ServiceException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer userId = user.getId();

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();

        int id = arg.getPetId();
        Pet pet = petService.findById(id);
        if (pet.getUser().getId().equals(userId)) {
            sra.setAttribute("pet", new SelectedPet(pet), ServletRequestAttributes.SCOPE_SESSION);
            SelectPetResult result = new SelectPetResult();
            result.setSuccess(true);
            return result;
        } else {
            throw new ServiceException();
        }
    }

    /**
     * @return the petService
     */
    public ru.urvanov.virtualpets.server.service.PetService getPetService() {
        return petService;
    }

    /**
     * @param petService
     *            the petService to set
     */
    public void setPetService(
            ru.urvanov.virtualpets.server.service.PetService petService) {
        this.petService = petService;
    }

    /**
     * @return the conversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * @param conversionService
     *            the conversionService to set
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public void drink(DrinkArg drinkArg) throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        DrinkType drinkType =  conversionService.convert(drinkArg.getDrinkType(), DrinkType.class);
        Map<Drink, PetDrink> drinks = pet.getDrinks();
        PetDrink petDrink = drinks.get(drinkService.findByCode(drinkType));
        petDrink.setDrinkCount(petDrink.getDrinkCount() - 1);
        pet.setDrink(100);
        JournalEntry buildRefrigeratorJournalEntry = journalEntryService.findByCode(JournalEntryType.BUILD_REFRIGERATOR);
        if (pet.getJournalEntries().get(buildRefrigeratorJournalEntry) == null) {
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(pet);
            newPetJournalEntry.setJournalEntry(buildRefrigeratorJournalEntry);
            newPetJournalEntry.setReaded(false);
            pet.getJournalEntries().put(newPetJournalEntry.getJournalEntry(), newPetJournalEntry);
        }
        sra.setAttribute("pet", new SelectedPet(pet), ServletRequestAttributes.SCOPE_SESSION);
        if (pet.getDrinkCount() < Integer.MAX_VALUE) pet.setDrinkCount(pet.getDrinkCount() + 1);
        Achievement achievementDrink1 = achievementService.findByCode(AchievementCode.DRINK_1);
        Achievement achievementDrink10 = achievementService.findByCode(AchievementCode.DRINK_10);
        Achievement achievementDrink100 = achievementService.findByCode(AchievementCode.DRINK_100);
        if (pet.getDrinkCount().equals(Integer.valueOf(1))) addAchievementIfNot(pet, achievementDrink1);
        if (pet.getDrinkCount().equals(Integer.valueOf(10))) addAchievementIfNot(pet, achievementDrink10);
        if (pet.getDrinkCount().equals(Integer.valueOf(100))) addAchievementIfNot(pet, achievementDrink100);
        petService.addExperience(petService.findById(pet.getId()), 1);
        petService.save(pet);
        
        
    }

    private void addAchievementIfNot(Pet pet, Achievement achievement) {
        if (!pet.getAchievements().containsKey(achievement)) {
            PetAchievement petAchievement = new PetAchievement();
            petAchievement.setPet(pet);
            petAchievement.setAchievement(achievement);
            pet.getAchievements().put(achievement, petAchievement);
        }
    }

    @Override
    @Transactional
    public void satiety(SatietyArg satietyArg) throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);

        FoodType foodType = conversionService.convert(satietyArg.getFoodType(),
                ru.urvanov.virtualpets.server.domain.FoodType.class);
        Pet pet = petService.findById(selectedPet.getId());
        PetFood food = foodService.findByPetAndFoodType(pet, foodType);
        if (food == null) {
            throw new ServiceException("Food count = 0.");
        } else {
            if (food.getFoodCount().equals(0)) {
                throw new ServiceException("Food count = 0.");
            }
            food.setFoodCount(food.getFoodCount() - 1);
            foodService.save(food);
        }
        pet.setSatiety(100);
        JournalEntry buildBookcaseJournalEntry = journalEntryService.findByCode(JournalEntryType.BUILD_BOOKCASE);
        if (pet.getJournalEntries().get(buildBookcaseJournalEntry) == null) {
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(pet);
            newPetJournalEntry.setJournalEntry(buildBookcaseJournalEntry);
            newPetJournalEntry.setReaded(false);
            pet.getJournalEntries().put(newPetJournalEntry.getJournalEntry(), newPetJournalEntry);
        }
        sra.setAttribute("pet", new SelectedPet(pet), ServletRequestAttributes.SCOPE_SESSION);
        if (pet.getEatCount() < Integer.MAX_VALUE) pet.setEatCount(pet.getEatCount() + 1);
        Achievement achievementEat1 = achievementService.findByCode(AchievementCode.FEED_1);
        Achievement achievementEat10 = achievementService.findByCode(AchievementCode.FEED_10);
        Achievement achievementEat100 = achievementService.findByCode(AchievementCode.FEED_100);
        if (pet.getEatCount().equals(Integer.valueOf(1))) addAchievementIfNot(pet, achievementEat1);
        if (pet.getEatCount().equals(Integer.valueOf(10))) addAchievementIfNot(pet, achievementEat10);
        if (pet.getEatCount().equals(Integer.valueOf(100))) addAchievementIfNot(pet, achievementEat100);
        petService.addExperience(petService.findById(pet.getId()), 1);
        petService.save(pet);
        
    }

    @Override
    @Transactional
    public void education() throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet)  sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findById(selectedPet.getId());
        pet.setEducation(100);
        
        JournalEntry leaveRoomJournalEntry = journalEntryService.findByCode(JournalEntryType.LEAVE_ROOM);
        if (pet.getJournalEntries().get(leaveRoomJournalEntry) == null) {
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(pet);
            newPetJournalEntry.setJournalEntry(leaveRoomJournalEntry);
            newPetJournalEntry.setReaded(false);
            pet.getJournalEntries().put(newPetJournalEntry.getJournalEntry(), newPetJournalEntry);
        }
        
        sra.setAttribute("pet", new SelectedPet(pet), ServletRequestAttributes.SCOPE_SESSION);
        if (pet.getTeachCount() < Integer.MAX_VALUE) pet.setTeachCount(pet.getTeachCount() + 1);
        Achievement achievementTeach1 = achievementService.findByCode(AchievementCode.TEACH_1);
        Achievement achievementTeach10 = achievementService.findByCode(AchievementCode.TEACH_10);
        Achievement achievementTeach100 = achievementService.findByCode(AchievementCode.TEACH_100);
        if (pet.getTeachCount().equals(Integer.valueOf(1))) addAchievementIfNot(pet, achievementTeach1);
        if (pet.getTeachCount().equals(Integer.valueOf(10))) addAchievementIfNot(pet, achievementTeach10);
        if (pet.getTeachCount().equals(Integer.valueOf(100))) addAchievementIfNot(pet, achievementTeach100);
        petService.addExperience(petService.findById(pet.getId()), 1);
        petService.save(pet);
        
    }

    @Override
    public void mood() throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        Pet pet = (Pet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        pet = petService.findById(pet.getId());
        pet.setMood(100);
        sra.setAttribute("pet", new SelectedPet(pet), ServletRequestAttributes.SCOPE_SESSION);
        petService.addExperience(petService.findById(pet.getId()), 1);
        petService.save(pet);
        
    }

    /**
     * @return the foodService
     */
    public ru.urvanov.virtualpets.server.service.PetFoodService getFoodService() {
        return foodService;
    }

    /**
     * @param foodService
     *            the foodService to set
     */
    public void setFoodService(
            ru.urvanov.virtualpets.server.service.PetFoodService foodService) {
        this.foodService = foodService;
    }

}
