/**
 * 
 */
package ru.urvanov.virtualpets.server.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;

/**
 * @author fedya
 *
 */
public class JournalServiceImplTest extends AbstractServiceImplTest {
    
    @Autowired
    private JournalEntryService journalEntryService;


    @Test
    public void testFind1() {
        JournalEntry journalEntry = journalEntryService.findById(1);
        assertNotNull(journalEntry);
    }
    
    
    @Test
    public void testFind2() {
        JournalEntry journalEntry = journalEntryService.findByCode(JournalEntryType.WELCOME);
        assertNotNull(journalEntry);
    }
    
    
    @Test
    public void testFind3() {
        JournalEntry journalEntry = journalEntryService.getReference(1);
        assertNotNull(journalEntry);;
    }
    

}
