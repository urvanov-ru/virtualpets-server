/**
 * 
 */
package ru.urvanov.virtualpets.server.service;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.urvanov.virtualpets.server.domain.Food;
import ru.urvanov.virtualpets.server.domain.FoodType;
import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetFood;
import ru.urvanov.virtualpets.server.domain.PetJournalEntry;
import ru.urvanov.virtualpets.server.domain.PetType;
import ru.urvanov.virtualpets.server.test.annotation.DataSets;

/**
 * @author fedya
 *
 */
public class PetServiceImplTest extends AbstractServiceImplTest {
    
    @Autowired
    private PetService petService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private LevelService levelService;
    
    @Autowired
    private JournalEntryService journalEntryService;
    
    @Autowired
    private FoodService foodService;
        
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/PetServiceImplTest.xls")
    @Test
    public void testSave() {
        List<Pet> pets = petService.findByUserId(1);
        int lastSize = pets.size();
        Pet pet = new Pet();
        pet.setName("test4y84hg4");
        pet.setCreatedDate(new Date());
        pet.setLoginDate(new Date());
        pet.setPetType(PetType.CAT);
        pet.setUser(userService.findByLogin("Clarence"));
        pet.setLevel(levelService.findById(1));
        petService.save(pet);
        int newSize = petService.findByUserId(1).size();
        assertEquals(lastSize + 1, newSize);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/PetServiceImplTest.xls")
    @Test
    public void testGetNewJournalEntriesCount() {
        Pet pet = petService.findById(1);
        Long newJournalEntriesCount = petService.getPetNewJournalEntriesCount(pet.getId());
        assertEquals(Long.valueOf(0L), newJournalEntriesCount);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/PetServiceImplTest.xls")
    @Test
    public void testAddJournalEntry() {
        Pet pet = petService.findById(1);
        JournalEntry journalEntry = journalEntryService.findByCode(JournalEntryType.EAT_SOMETHING);
        PetJournalEntry petJournalEntry = new PetJournalEntry();
        petJournalEntry.setJournalEntry(journalEntry);
        petJournalEntry.setReaded(true);
        
        pet.getJournalEntries().put(journalEntry, petJournalEntry);
        //petJournalEntry.setPet(pet);
        petService.save(pet);
        
        pet = petService.findFullById(1);
        assertTrue(pet.getJournalEntries().get(journalEntry).getReaded());
    }
    
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/PetServiceImplTest.xls")
    @Test
    @Transactional
    public void testAddFood() {
        Pet pet = petService.findById(1);
        Food food = foodService.findByCode(FoodType.CARROT);
        PetFood petFood = new PetFood();
        petFood.setPet(pet);
        petFood.setFood(food);
        petFood.setFoodCount(10);
        pet.getFoods().put(food,  petFood);
        petService.save(pet);
        
        pet = petService.findFullById(1);
        assertEquals(10, pet.getFoods().get(food).getFoodCount());
    }

    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
