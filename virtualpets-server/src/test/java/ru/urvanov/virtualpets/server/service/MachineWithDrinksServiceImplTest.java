/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.urvanov.virtualpets.server.domain.MachineWithDrinks;
import ru.urvanov.virtualpets.server.test.annotation.DataSets;

/**
 * @author fedya
 *
 */
public class MachineWithDrinksServiceImplTest extends AbstractServiceImplTest {
    
    @Autowired
    private MachineWithDrinksService machineWithDrinksService;

    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    public void testFind1() {
        MachineWithDrinks drink = machineWithDrinksService.findById(1);
        assertNotNull(drink);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    public void testFind2() {
        MachineWithDrinks drink = machineWithDrinksService.findFullById(1);
        assertNotNull(drink);
        assertNotNull(drink.getMachineWithDrinksCost());
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    public void testFind3() {
        MachineWithDrinks drink = machineWithDrinksService.findById(-1);
        assertNull(drink);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    public void testFind4() {
        MachineWithDrinks drink = machineWithDrinksService.findFullById(-1);
        assertNull(drink);
    }
}
