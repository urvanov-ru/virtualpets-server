/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import java.util.List;

import ru.urvanov.virtualpets.server.domain.FoodType;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetFood;

/**
 * @author fedya
 *
 */
public interface PetFoodService {
    public PetFood findById(Integer id);
    public List<PetFood> findByPetId(Integer petId);
    public List<PetFood> findByPet(Pet pet);
    public PetFood findByPetIdAndFoodType(Integer petId, FoodType foodType);
    public PetFood findByPetAndFoodType(Pet pet, FoodType foodType);
    public void save(PetFood food);
}
