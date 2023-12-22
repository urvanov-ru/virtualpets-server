/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.urvanov.virtualpets.server.domain.Refrigerator;
import ru.urvanov.virtualpets.server.test.annotation.DataSets;

/**
 * @author fedya
 *
 */
public class RefrigeratorServiceImplTest extends AbstractServiceImplTest {
    
    @Autowired
    private RefrigeratorService refrigeratorService;

    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RefrigeratorServiceImplTest.xls")
    @Test
    public void testFind1() {
        Refrigerator refrigerator = refrigeratorService.findById(1);
        assertNotNull(refrigerator);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RefrigeratorServiceImplTest.xls")
    @Test
    public void testFind2() {
        Refrigerator refrigerator = refrigeratorService.findFullById(2);
        assertNotNull(refrigerator);
        assertNotNull(refrigerator.getRefrigeratorCost());
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RefrigeratorServiceImplTest.xls")
    @Test
    public void testFind3() {
        Refrigerator refrigerator = refrigeratorService.findById(-1);
        assertNull(refrigerator);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RefrigeratorServiceImplTest.xls")
    @Test
    public void testFind4() {
        Refrigerator refrigerator = refrigeratorService.findFullById(-1);
        assertNull(refrigerator);
    }
}
