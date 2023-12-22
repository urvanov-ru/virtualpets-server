/**
 * 
 */
package ru.urvanov.virtualpets.server.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;

import ru.urvanov.virtualpets.server.domain.Bookcase;
import ru.urvanov.virtualpets.server.test.annotation.DataSets;

/**
 * @author fedya
 *
 */
public class BookcaseServiceImplTest extends AbstractServiceImplTest {
    
    @Autowired
    BookcaseService bookcaseService;

    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    void testFind1() {
        Bookcase bookcase = bookcaseService.findById(1);
        assertNotNull(bookcase);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    void testFind2() {
        Bookcase bookcase = bookcaseService.findFullById(1);
        assertNotNull(bookcase);
        assertNotNull(bookcase.getBookcaseCost());
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    void testFind3() {
        Bookcase bookcase = bookcaseService.findById(-1);
        assertNull(bookcase);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/BookcaseServiceImplTest.xls")
    @Test
    void testFind4() {
        Bookcase bookcase = bookcaseService.findFullById(-1);
        assertNull(bookcase);
    }
}
