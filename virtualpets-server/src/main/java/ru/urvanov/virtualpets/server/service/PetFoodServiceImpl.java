/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.PetFoodDao;
import ru.urvanov.virtualpets.server.domain.FoodType;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetFood;
/**
 * @author fedya
 *
 */
@Service(value="petFoodService")
public class PetFoodServiceImpl implements PetFoodService {

    @Autowired
    private PetFoodDao foodDao;
    
    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.FoodService#findById(java.lang.Integer)
     */
    @Override
    public PetFood findById(Integer id) {
        return foodDao.findById(id);
    }

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.FoodService#findByPetId(java.lang.Integer)
     */
    @Override
    public List<PetFood> findByPetId(Integer petId) {
        return foodDao.findByPetId(petId);
    }

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.FoodService#findByPet(ru.urvanov.virtualpets.server.domain.Pet)
     */
    @Override
    public List<PetFood> findByPet(Pet pet) {
        return foodDao.findByPet(pet);
    }

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.FoodService#save(ru.urvanov.virtualpets.server.domain.Food)
     */
    @Override
    public void save(PetFood food) {
        foodDao.save(food);
    }

    /**
     * @return the foodDao
     */
    public PetFoodDao getFoodDao() {
        return foodDao;
    }

    /**
     * @param foodDao the foodDao to set
     */
    public void setFoodDao(PetFoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public PetFood findByPetIdAndFoodType(Integer petId, FoodType foodType) {
        return foodDao.findByPetIdAndFoodType(petId, foodType);
    }

    @Override
    public PetFood findByPetAndFoodType(Pet pet, FoodType foodType) {
        return findByPetIdAndFoodType(pet.getId(), foodType);
    }

}
