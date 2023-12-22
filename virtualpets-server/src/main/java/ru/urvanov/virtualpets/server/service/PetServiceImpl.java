/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.LevelDao;
import ru.urvanov.virtualpets.server.dao.PetDao;
import ru.urvanov.virtualpets.server.domain.Achievement;
import ru.urvanov.virtualpets.server.domain.AchievementCode;
import ru.urvanov.virtualpets.server.domain.Bookcase;
import ru.urvanov.virtualpets.server.domain.BookcaseCost;
import ru.urvanov.virtualpets.server.domain.BuildingMaterial;
import ru.urvanov.virtualpets.server.domain.Level;
import ru.urvanov.virtualpets.server.domain.MachineWithDrinks;
import ru.urvanov.virtualpets.server.domain.MachineWithDrinksCost;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetAchievement;
import ru.urvanov.virtualpets.server.domain.PetBuildingMaterial;
import ru.urvanov.virtualpets.server.domain.Refrigerator;
import ru.urvanov.virtualpets.server.domain.RefrigeratorCost;
import ru.urvanov.virtualpets.server.service.exception.NotEnoughPetResourcesException;
/**
 * @author fedya
 *
 */
@Service(value="petService")
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDao petDao;
    
    @Autowired
    private PetFoodService foodService;
    
    @Autowired
    private LevelDao levelDao;
    
    /**
     * 
     */
    public PetServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Pet findById(Integer id) {
        return petDao.findById(id);
    }
    
    @Override
    public Pet findFullById(Integer id) {
        return petDao.findFullById(id);
    }

    @Override
    public void save(Pet pet) {
        //boolean firstInsert = false;
        //if (pet.getId() == null) {
        //    firstInsert = true;
        //}
        petDao.save(pet);
        /*if (firstInsert) {
            PetFood food = new PetFood();
            food.setFoodType(FoodType.DRY_FOOD);
            food.setFoodCount(9);
            food.setPet(pet);
            foodService.save(food);
        }*/
    }
    
    @Override
    public void addExperience(Pet pet, Integer exp) {
        int nextExperience = pet.getExperience() + exp;
        Level nextLevel = levelDao.findById(pet.getLevel().getId() + 1);
        if (nextLevel == null) {
            Level lastLevel = levelDao.findById(pet.getLevel().getId());
            pet.setExperience(Math.min(nextExperience, lastLevel.getExperience()));
        } else {
            pet.setExperience(nextExperience);
            if (nextExperience >= nextLevel.getExperience()) {
                pet.setLevel(nextLevel);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        petDao.delete(id);
    }

    @Override
    public List<Pet> findByUserId(Integer userId) {
        return petDao.findByUserId(userId);
    }

    /**
     * @return the petDao
     */
    public PetDao getPetDao() {
        return petDao;
    }

    /**
     * @param petDao the petDao to set
     */
    public void setPetDao(PetDao petDao) {
        this.petDao = petDao;
    }

    /**
     * @return the foodService
     */
    public PetFoodService getFoodService() {
        return foodService;
    }

    /**
     * @param foodService the foodService to set
     */
    public void setFoodService(PetFoodService foodService) {
        this.foodService = foodService;
    }

    @Override
    public Pet getReference(Integer id) {
        return petDao.getReference(id);
    }

    @Override
    public void updatePetsTask() {
        petDao.updatePetsTask();
    }
    
    @Override
    public void substractPetResources(Pet fullPet, Refrigerator refrigerator) throws NotEnoughPetResourcesException {
        Map<BuildingMaterial, PetBuildingMaterial> petBuildingMaterials = fullPet.getBuildingMaterials();
        Map<BuildingMaterial, RefrigeratorCost> resourceCosts =  refrigerator.getRefrigeratorCost();
        for (Entry<BuildingMaterial, RefrigeratorCost> entry : resourceCosts.entrySet()) {
            BuildingMaterial buildingMaterial = entry.getKey();
            RefrigeratorCost resourceCost = entry.getValue();
            PetBuildingMaterial petBuildingMaterial = petBuildingMaterials.get(buildingMaterial);
            if (petBuildingMaterial == null) {
                throw new NotEnoughPetResourcesException();
            } else {
                int newCount = petBuildingMaterial.getBuildingMaterialCount() - resourceCost.getCost();
                if (newCount < 0) {
                    throw new NotEnoughPetResourcesException();
                }
                petBuildingMaterial.setBuildingMaterialCount(newCount);
            }
        }
    }
    
    @Override
    public void substractPetResources(Pet fullPet, Bookcase bookcase) throws NotEnoughPetResourcesException {
        Map<BuildingMaterial, PetBuildingMaterial> petBuildingMaterials = fullPet.getBuildingMaterials();
        Map<BuildingMaterial, BookcaseCost> resourceCosts =  bookcase.getBookcaseCost();
        for (Entry<BuildingMaterial, BookcaseCost> entry : resourceCosts.entrySet()) {
            BuildingMaterial buildingMaterial = entry.getKey();
            BookcaseCost resourceCost = entry.getValue();
            PetBuildingMaterial petBuildingMaterial = petBuildingMaterials.get(buildingMaterial);
            if (petBuildingMaterial == null) {
                throw new NotEnoughPetResourcesException();
            } else {
                int newCount = petBuildingMaterial.getBuildingMaterialCount() - resourceCost.getCost();
                if (newCount < 0) {
                    throw new NotEnoughPetResourcesException();
                }
                petBuildingMaterial.setBuildingMaterialCount(newCount);
            }
        }
    }
    
    @Override
    public void substractPetResources(Pet fullPet, MachineWithDrinks drink) throws NotEnoughPetResourcesException {
        Map<BuildingMaterial, PetBuildingMaterial> petBuildingMaterials = fullPet.getBuildingMaterials();
        Map<BuildingMaterial, MachineWithDrinksCost> resourceCosts =  drink.getMachineWithDrinksCost();
        for (Entry<BuildingMaterial, MachineWithDrinksCost> entry : resourceCosts.entrySet()) {
            BuildingMaterial buildingMaterial = entry.getKey();
            MachineWithDrinksCost resourceCost = entry.getValue();
            PetBuildingMaterial petBuildingMaterial = petBuildingMaterials.get(buildingMaterial);
            if (petBuildingMaterial == null) {
                throw new NotEnoughPetResourcesException();
            } else {
                int newCount = petBuildingMaterial.getBuildingMaterialCount() - resourceCost.getCost();
                if (newCount < 0) {
                    throw new NotEnoughPetResourcesException();
                }
                petBuildingMaterial.setBuildingMaterialCount(newCount);
            }
        }
    }

    @Override
    public Long getPetNewJournalEntriesCount(Integer petId) {
        return petDao.getPetNewJournalEntriesCount(petId);
    }

    @Override
    public List<AchievementCode> calculateAchievements(Pet fullPet) {
        List<AchievementCode> result = new ArrayList<AchievementCode>();
        Map<Achievement, PetAchievement> map = fullPet.getAchievements();
        for (PetAchievement pa : map.values()) {
            if (!pa.getWasShown()) {
                pa.setWasShown(true);
                result.add(pa.getAchievement().getCode());
            }
        }
        return result;
    }

    @Override
    public List<Pet> findLastCreatedPets(int start, int limit) {
        return petDao.findLastCreatedPets(start, limit);
    }
    
    @Override
    public void addAchievementIfNot(Pet pet, Achievement achievement) {
        if (!pet.getAchievements().containsKey(achievement)) {
            PetAchievement petAchievement = new PetAchievement();
            petAchievement.setPet(pet);
            petAchievement.setAchievement(achievement);
            pet.getAchievements().put(achievement, petAchievement);
        }
    }
}
