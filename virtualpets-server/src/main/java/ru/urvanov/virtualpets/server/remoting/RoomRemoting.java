/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.AchievementCode;
import ru.urvanov.virtualpets.server.domain.Book;
import ru.urvanov.virtualpets.server.domain.Bookcase;
import ru.urvanov.virtualpets.server.domain.BookcaseCost;
import ru.urvanov.virtualpets.server.domain.BuildingMaterial;
import ru.urvanov.virtualpets.server.domain.BuildingMaterialType;
import ru.urvanov.virtualpets.server.domain.Cloth;
import ru.urvanov.virtualpets.server.domain.Drink;
import ru.urvanov.virtualpets.server.domain.DrinkType;
import ru.urvanov.virtualpets.server.domain.Food;
import ru.urvanov.virtualpets.server.domain.FoodType;
import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;
import ru.urvanov.virtualpets.server.domain.Level;
import ru.urvanov.virtualpets.server.domain.MachineWithDrinks;
import ru.urvanov.virtualpets.server.domain.MachineWithDrinksCost;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetBuildingMaterial;
import ru.urvanov.virtualpets.server.domain.PetDrink;
import ru.urvanov.virtualpets.server.domain.PetFood;
import ru.urvanov.virtualpets.server.domain.PetJournalEntry;
import ru.urvanov.virtualpets.server.domain.Refrigerator;
import ru.urvanov.virtualpets.server.domain.RefrigeratorCost;
import ru.urvanov.virtualpets.server.domain.Room;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.server.service.exception.NotEnoughPetResourcesException;
import ru.urvanov.virtualpets.shared.domain.GetRoomInfoResult;
import ru.urvanov.virtualpets.shared.domain.LevelInfo;
import ru.urvanov.virtualpets.shared.domain.OpenBoxNewbieResult;
import ru.urvanov.virtualpets.shared.domain.Point;
import ru.urvanov.virtualpets.shared.domain.RoomBuildMenuCosts;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.RoomService;

/**
 * @author fedya
 * 
 */
@Service(value = "roomRemoting")
public class RoomRemoting implements RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomRemoting.class);
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.PetService petService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.RoomService roomService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.BuildingMaterialService buildingMaterialService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.RefrigeratorService refrigeratorService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.BookcaseService bookcaseService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.MachineWithDrinksService machineWithDrinksService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.JournalEntryService journalEntryService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.PetJournalEntryService petJournalEntryService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.FoodService foodService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.DrinkService drinkService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.BookService bookService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.LevelService levelService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.AchievementService achievementService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public GetRoomInfoResult getRoomInfo() throws DaoException,
            ServiceException {
        logger.info("getRoomInfo started.");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        ru.urvanov.virtualpets.shared.domain.GetRoomInfoResult result = new ru.urvanov.virtualpets.shared.domain.GetRoomInfoResult();
        result.setMood(pet.getMood());
        result.setEducation(pet.getEducation());
        result.setSatiety(pet.getSatiety());
        result.setDrink(pet.getDrink());
        result.setNewJournalEntriesCount(petService
                .getPetNewJournalEntriesCount(pet.getId()));

        Cloth hat = pet.getHat();
        Cloth cloth = pet.getCloth();
        Cloth bow = pet.getBow();
        if (hat != null) {
            result.setHatId(hat.getId());
        }
        if (cloth != null) {
            result.setClothId(cloth.getId());
        }
        if (bow != null) {
            result.setBowId(bow.getId());
        }
        LevelInfo levelInfo = new LevelInfo();
        result.setLevelInfo(levelInfo);
        levelInfo.setLevel(pet.getLevel().getId());
        levelInfo.setExperience(pet.getExperience());
        Level nextLevelLeague = levelService.findById(pet.getLevel().getId() + 1);
        levelInfo.setMaxExperience(nextLevelLeague == null ? Integer.MAX_VALUE : nextLevelLeague.getExperience());
        levelInfo.setMinExperience(pet.getLevel().getExperience());
        
        
        result.setHaveJournal(pet.getJournalEntries().get(
                journalEntryService.findByCode(JournalEntryType.WELCOME)) != null);
        result.setHaveHammer(pet
                .getJournalEntries()
                .get(journalEntryService
                        .findByCode(JournalEntryType.BUILD_MACHINE_WITH_DRINKS)) != null);
        result.setHaveRucksack(pet.getJournalEntries().get(
                journalEntryService
                        .findByCode(JournalEntryType.OPEN_NEWBIE_BOXES)) != null);
        result.setHaveIndicators(pet.getJournalEntries().get(
                journalEntryService
                        .findByCode(JournalEntryType.DRINK_SOMETHING)) != null);
        result.setHaveToTownArrow(pet.getJournalEntries()
                .get(journalEntryService
                        .findByCode(JournalEntryType.LEAVE_ROOM)) != null);

        Room room = roomService.findOrCreateByPet(pet);
        Refrigerator refrigerator = room.getRefrigerator();
        if (refrigerator != null) {
            result.setRefrigeratorId(refrigerator.getId());
            result.setRefrigeratorX(room.getRefrigeratorX());
            result.setRefrigeratorY(room.getRefrigeratorY());
        }
        boolean[] boxesNewbie = new boolean[3];
        boxesNewbie[0] = room.getBoxNewbie1();
        boxesNewbie[1] = room.getBoxNewbie2();
        boxesNewbie[2] = room.getBoxNewbie3();
        result.setBoxesNewbie(boxesNewbie);
        result.setJournalOnFloor(room.getJournalOnFloor());
        Bookcase bookcase = room.getBookcase();
        if (bookcase != null) {
            result.setBookcaseId(bookcase.getId());
            result.setBookcaseX(room.getBookcaseX());
            result.setBookcaseY(room.getBookcaseY());
        }
        MachineWithDrinks drink = room.getMachineWithDrinks();
        if (drink != null) {
            result.setMachineWithDrinksId(drink.getId());
            result.setMachineWithDrinksX(room.getMachineWithDrinksX());
            result.setMachineWithDrinksY(room.getMachineWithDrinksY());
        }
        
        List<AchievementCode> listServerAchievements = petService.calculateAchievements(pet);
        ru.urvanov.virtualpets.shared.domain.AchievementCode[] listSharedAchievements = new ru.urvanov.virtualpets.shared.domain.AchievementCode[listServerAchievements.size()];
        int n = 0;
        for (AchievementCode ac : listServerAchievements) {
            listSharedAchievements[n] = conversionService.convert(ac, ru.urvanov.virtualpets.shared.domain.AchievementCode.class);
            n++;
        }
        result.setAchievements(listSharedAchievements);
        petService.save(pet);
        logger.info("getRoomInfo finished.");
        return result;
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
     * @return the roomService
     */
    public ru.urvanov.virtualpets.server.service.RoomService getRoomService() {
        return roomService;
    }

    /**
     * @param roomService
     *            the roomService to set
     */
    public void setRoomService(
            ru.urvanov.virtualpets.server.service.RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public OpenBoxNewbieResult openBoxNewbie(int index) throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        OpenBoxNewbieResult result = new OpenBoxNewbieResult();
        Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer> map = new HashMap<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>();
        Random random = new Random();
        map.put(ru.urvanov.virtualpets.shared.domain.BuildingMaterialType.TIMBER,
                1 + random.nextInt(2));
        map.put(ru.urvanov.virtualpets.shared.domain.BuildingMaterialType.STONE,
                1 + random.nextInt(2));
        result.setBuildingMaterials(map);
        Room room = roomService.findByPetId(selectedPet.getId());
        boolean boxNewbie = false;
        switch (index) {
        case 0:
            boxNewbie = room.getBoxNewbie1();
            break;
        case 1:
            boxNewbie = room.getBoxNewbie2();
            break;
        case 2:
            boxNewbie = room.getBoxNewbie3();
            break;
        }
        if (boxNewbie) {
            Pet pet = petService.findFullById(selectedPet.getId());
            Map<BuildingMaterial, PetBuildingMaterial> petBuildingMaterials = pet
                    .getBuildingMaterials();
            for (Entry<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer> entry : map
                    .entrySet()) {
                BuildingMaterialType buildingMaterialType = conversionService
                        .convert(entry.getKey(), BuildingMaterialType.class);
                BuildingMaterial buildingMaterial = buildingMaterialService
                        .findByCode(buildingMaterialType);
                PetBuildingMaterial petBuildingMaterial = petBuildingMaterials
                        .get(buildingMaterial);
                if (petBuildingMaterial == null) {
                    petBuildingMaterial = new PetBuildingMaterial();
                    petBuildingMaterial.setBuildingMaterial(buildingMaterial);
                    petBuildingMaterial.setBuildingMaterialCount(entry
                            .getValue());
                    petBuildingMaterial.setPet(pet);
                    petBuildingMaterials.put(buildingMaterial,
                            petBuildingMaterial);
                } else {
                    petBuildingMaterial
                            .setBuildingMaterialCount(petBuildingMaterial
                                    .getBuildingMaterialCount()
                                    + entry.getValue());
                }
            }

            
            switch (index) {
            case 0:
                room.setBoxNewbie1(false);
                break;
            case 1:
                room.setBoxNewbie2(false);
                break;
            case 2:
                room.setBoxNewbie3(false);
                break;
            }
            roomService.save(room);
            petService.addExperience(pet, 1);
            
            if (!room.getBoxNewbie1() && !room.getBoxNewbie2()
                    && !room.getBoxNewbie3()) {
                PetJournalEntry newPetJournalEntry = new PetJournalEntry();
                newPetJournalEntry.setCreatedAt(new Date());
                newPetJournalEntry.setPet(pet);
                JournalEntry buildMachineWithDrinksJournalEntry = journalEntryService
                        .findByCode(JournalEntryType.BUILD_MACHINE_WITH_DRINKS);
                newPetJournalEntry
                        .setJournalEntry(buildMachineWithDrinksJournalEntry);
                newPetJournalEntry.setReaded(false);
                pet.getJournalEntries().put(
                        newPetJournalEntry.getJournalEntry(),
                        newPetJournalEntry);
            }
            petService.save(pet);
        } else {
            throw new ServiceException("This box already opened.");
        }
        result.setIndex(index);
        return result;
    }

    /**
     * @param conversionService
     *            the conversionService to set
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public void buildRefrigerator(
            ru.urvanov.virtualpets.shared.domain.Point arg)
            throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Room room = roomService.findByPet(pet);
        if (pet.getJournalEntries().get(
                journalEntryService
                        .findByCode(JournalEntryType.BUILD_REFRIGERATOR)) == null) {
            throw new ServiceException("No now.");
        }
        
        final int DRY_FOOD_ADD_COUNT = 10;
        Food dryFood = foodService.findByCode(FoodType.DRY_FOOD);
        PetFood petDryFood = pet.getFoods().get(dryFood);
        if (petDryFood == null) {
            petDryFood = new PetFood();
            petDryFood.setFood(dryFood);
            petDryFood.setPet(pet);
            petDryFood.setFoodCount(DRY_FOOD_ADD_COUNT);
            pet.getFoods().put(dryFood, petDryFood);
        } else {
            petDryFood.setFoodCount(petDryFood.getFoodCount() + DRY_FOOD_ADD_COUNT);
        }
        
        
        Refrigerator refrigerator = refrigeratorService.findFullById(1);
        try {
            petService.substractPetResources(pet, refrigerator);
        } catch (NotEnoughPetResourcesException nepre) {
            throw new ServiceException(nepre.toString());
        }
        room.setRefrigerator(refrigerator);
        room.setRefrigeratorX(arg.getX());
        room.setRefrigeratorY(arg.getY());
        roomService.save(room);
        JournalEntry eatSomethingJournalEntry = journalEntryService
                .findByCode(JournalEntryType.EAT_SOMETHING);
        if (pet.getJournalEntries().get(eatSomethingJournalEntry) == null) {
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(pet);
            newPetJournalEntry.setJournalEntry(eatSomethingJournalEntry);
            newPetJournalEntry.setReaded(false);
            pet.getJournalEntries().put(newPetJournalEntry.getJournalEntry(),
                    newPetJournalEntry);
            petService.addExperience(pet, 1);

        }
        petService.save(pet);
    }

    @Override
    public void moveRefrigerator(Point arg) throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Room room = roomService.findByPetId(selectedPet.getId());
        if (room.getRefrigerator() == null) {
            throw new ServiceException("No refrigerator in your room.");
        }
        room.setRefrigeratorX(arg.getX());
        room.setRefrigeratorY(arg.getY());
        roomService.save(room);
    }

    @Override
    public void upgradeRefrigerator() throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Room room = roomService.findByPet(pet);
        if (room.getRefrigerator() == null) {
            throw new ServiceException("No refrigerator in your room.");
        }
        
        Refrigerator refrigerator = refrigeratorService.findFullById(room
                .getRefrigerator().getId() + 1);
        if (refrigerator == null) {
            throw new ServiceException("Your refrigerator level is max.");
        }
        try {
            petService.substractPetResources(pet, refrigerator);
        } catch (NotEnoughPetResourcesException nepre) {
            throw new ServiceException(nepre.toString());
        }
        room.setRefrigerator(refrigerator);
        roomService.save(room);
        petService.addExperience(pet, 1);
        petService.save(pet);
    }

    @Override
    public void buildBookcase(Point arg) throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Room room = roomService.findByPet(pet);
        if (pet.getJournalEntries()
                .get(journalEntryService
                        .findByCode(JournalEntryType.BUILD_BOOKCASE)) == null) {
            throw new ServiceException("Not now.");
        }
        
        
        Book book = bookService.findById(1);
        
        if (!pet.getBooks().contains(book)) {
            pet.getBooks().add(book);
        }
        
        Bookcase bookcase = bookcaseService.findFullById(1);
        try {
            petService.substractPetResources(pet, bookcase);
        } catch (NotEnoughPetResourcesException nepre) {
            throw new ServiceException(nepre);
        }
        room.setBookcase(bookcase);
        room.setBookcaseX(arg.getX());
        room.setBookcaseY(arg.getY());
        roomService.save(room);
        JournalEntry readSomethingJournalEntry = journalEntryService
                .findByCode(JournalEntryType.READ_SOMETHING);
        if (pet.getJournalEntries().get(readSomethingJournalEntry) == null) {
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(pet);
            newPetJournalEntry.setJournalEntry(readSomethingJournalEntry);
            newPetJournalEntry.setReaded(false);
            pet.getJournalEntries().put(newPetJournalEntry.getJournalEntry(),
                    newPetJournalEntry);
            petService.addExperience(pet, 1);
            
            
        }
        petService.save(pet);
    }

    @Override
    public void upgradeBookcase() throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Room room = roomService.findByPet(pet);
        if (room.getBookcase() == null) {
            throw new ServiceException("No bookcase in your room.");
        }
        Bookcase bookcase = bookcaseService.findFullById(room.getBookcase()
                .getId() + 1);
        if (bookcase == null) {
            throw new ServiceException("Your bookcase level is max.");
        }
        try {
            petService.substractPetResources(pet, bookcase);
        } catch (NotEnoughPetResourcesException nepre) {
            throw new ServiceException(nepre.toString());
        }
        room.setBookcase(bookcase);
        roomService.save(room);
        petService.addExperience(pet, 1);
        petService.save(pet);
    }

    @Override
    public void moveBookcase(Point arg) throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Room room = roomService.findByPetId(selectedPet.getId());
        if (room.getBookcase() == null) {
            throw new ServiceException("No bookcase in your room.");
        }
        room.setBookcaseX(arg.getX());
        room.setBookcaseY(arg.getY());
        roomService.save(room);
    }

    @Override
    public void buildMachineWithDrinks(Point arg) throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Room room = roomService.findByPet(pet);
        if (pet.getJournalEntries()
                .get(journalEntryService
                        .findByCode(JournalEntryType.BUILD_MACHINE_WITH_DRINKS)) == null) {
            throw new ServiceException("Not now.");
        }
        
        final int WATER_ADD_COUNT = 10;
        
        Drink water = drinkService.findByCode(DrinkType.WATER);
        
        PetDrink petDrink = pet.getDrinks().get(water);
        if (petDrink == null) {
            petDrink = new PetDrink();
            petDrink.setDrink(water);
            petDrink.setPet(pet);
            petDrink.setDrinkCount(WATER_ADD_COUNT);
            pet.getDrinks().put(water, petDrink);
        } else {
            petDrink.setDrinkCount(petDrink.getDrinkCount() + WATER_ADD_COUNT);
        }
        
        
        MachineWithDrinks machineWithDrinks = machineWithDrinksService
                .findFullById(1);
        try {
            petService.substractPetResources(pet, machineWithDrinks);
        } catch (NotEnoughPetResourcesException nepre) {
            throw new ServiceException(nepre);
        }
        room.setMachineWithDrinks(machineWithDrinks);
        room.setMachineWithDrinksX(arg.getX());
        room.setMachineWithDrinksY(arg.getY());
        roomService.save(room);
        JournalEntry drinkSomethingJournalEntry = journalEntryService
                .findByCode(JournalEntryType.DRINK_SOMETHING);
        if (pet.getJournalEntries().get(drinkSomethingJournalEntry) == null) {
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(pet);
            newPetJournalEntry.setJournalEntry(drinkSomethingJournalEntry);
            newPetJournalEntry.setReaded(false);
            pet.getJournalEntries().put(newPetJournalEntry.getJournalEntry(),
                    newPetJournalEntry);
            petService.addExperience(petService.findById(pet.getId()), 1);
            petService.addAchievementIfNot(pet, achievementService.findByCode(AchievementCode.BUILD_1));
            
        }
        petService.save(pet);
    }

    @Override
    public void moveMachineWithDrinks(Point arg) throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Room room = roomService.findByPetId(selectedPet.getId());
        if (room.getMachineWithDrinks() == null) {
            throw new ServiceException("No drink in your room.");
        }
        room.setMachineWithDrinksX(arg.getX());
        room.setMachineWithDrinksY(arg.getY());
        roomService.save(room);
    }

    @Override
    public RoomBuildMenuCosts getBuildMenuCosts() throws DaoException,
            ServiceException {
        RoomBuildMenuCosts roomBuildMenuCosts = new RoomBuildMenuCosts();
        List<Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>> refrigeratorCosts = new ArrayList<Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>>();
        Refrigerator refrigerator = null;
        int index = 1;
        while ((refrigerator = refrigeratorService.findFullById(index)) != null) {
            index++;
            Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer> map = new HashMap<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>();
            for (Entry<BuildingMaterial, RefrigeratorCost> entry : refrigerator
                    .getRefrigeratorCost().entrySet()) {
                map.put(conversionService
                        .convert(
                                entry.getKey().getCode(),
                                ru.urvanov.virtualpets.shared.domain.BuildingMaterialType.class),
                        entry.getValue().getCost());
            }
            refrigeratorCosts.add(map);
        }
        roomBuildMenuCosts.setRefrigeratorCosts(refrigeratorCosts);

        List<Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>> bookcaseCosts = new ArrayList<Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>>();
        Bookcase bookcase = null;
        index = 1;
        while ((bookcase = bookcaseService.findFullById(index)) != null) {
            index++;
            Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer> map = new HashMap<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>();
            for (Entry<BuildingMaterial, BookcaseCost> entry : bookcase
                    .getBookcaseCost().entrySet()) {
                map.put(conversionService
                        .convert(
                                entry.getKey().getCode(),
                                ru.urvanov.virtualpets.shared.domain.BuildingMaterialType.class),
                        entry.getValue().getCost());
            }
            bookcaseCosts.add(map);
        }
        roomBuildMenuCosts.setBookcaseCosts(bookcaseCosts);

        List<Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>> drinkCosts = new ArrayList<Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>>();
        MachineWithDrinks drink = null;
        index = 1;
        while ((drink = machineWithDrinksService.findFullById(index)) != null) {
            index++;
            Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer> map = new HashMap<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>();
            for (Entry<BuildingMaterial, MachineWithDrinksCost> entry : drink
                    .getMachineWithDrinksCost().entrySet()) {
                map.put(conversionService
                        .convert(
                                entry.getKey().getCode(),
                                ru.urvanov.virtualpets.shared.domain.BuildingMaterialType.class),
                        entry.getValue().getCost());
            }
            drinkCosts.add(map);
        }
        roomBuildMenuCosts.setMachineWithDrinksCosts(drinkCosts);
        return roomBuildMenuCosts;

    }

    @Override
    public void upgradeMachineWithDrinks() throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Room room = roomService.findByPet(pet);
        if (room.getMachineWithDrinks() == null) {
            throw new ServiceException("No machine with drinks in your room.");
        }
        MachineWithDrinks machineWithDrinks = machineWithDrinksService
                .findFullById(room.getMachineWithDrinks().getId() + 1);
        if (machineWithDrinks == null) {
            throw new ServiceException("Your machine with drinks level is max.");
        }
        try {
            petService.substractPetResources(pet, machineWithDrinks);
        } catch (NotEnoughPetResourcesException nepre) {
            throw new ServiceException(nepre.toString());
        }
        room.setMachineWithDrinks(machineWithDrinks);
        roomService.save(room);
        petService.addExperience(pet, 1);
        petService.save(pet);
    }

    @Override
    @Transactional
    public void pickJournalOnFloor() throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Room room = roomService.findByPetId(selectedPet.getId());
        if (room.getJournalOnFloor() == false)
            throw new ServiceException("There isn't any journal in your room.");
        room.setJournalOnFloor(false);
        roomService.save(room);
        Pet pet = petService.findById(selectedPet.getId());
        Map<JournalEntry, PetJournalEntry> petJournalEntries = pet
                .getJournalEntries();
        JournalEntry journalEntry = journalEntryService
                .findByCode(JournalEntryType.WELCOME);
        if (pet.getJournalEntries().get(journalEntry) == null) {
            PetJournalEntry petJournalEntry = new PetJournalEntry();
            petJournalEntry.setCreatedAt(new Date());
            petJournalEntry.setJournalEntry(journalEntry);
            petJournalEntry.setReaded(false);
            petJournalEntry.setPet(pet);
            petJournalEntries.put(journalEntry, petJournalEntry);
            
        }
        petService.addExperience(pet, 1);
        petService.save(pet);
    }

    @Override
    public void journalClosed() throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet pet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        PetJournalEntry petJournalEntry = petJournalEntryService
                .findByPetIdAndJournalEntryCode(pet.getId(),
                        JournalEntryType.OPEN_NEWBIE_BOXES);
        if (petJournalEntry == null) {
            Pet fullPet = petService.findFullById(pet.getId());
            PetJournalEntry newPetJournalEntry = new PetJournalEntry();
            newPetJournalEntry.setCreatedAt(new Date());
            newPetJournalEntry.setPet(fullPet);
            newPetJournalEntry.setJournalEntry(journalEntryService
                    .findByCode(JournalEntryType.OPEN_NEWBIE_BOXES));
            newPetJournalEntry.setReaded(false);
            fullPet.getJournalEntries().put(
                    newPetJournalEntry.getJournalEntry(), newPetJournalEntry);
            petService.addExperience(fullPet, 1);
            petService.save(fullPet);
            
            Room room = roomService.findByPet(fullPet);
            room.setBoxNewbie1(true);
            room.setBoxNewbie2(true);
            room.setBoxNewbie3(true);
            
            roomService.save(room);
            
        }
        
        

    }
}
