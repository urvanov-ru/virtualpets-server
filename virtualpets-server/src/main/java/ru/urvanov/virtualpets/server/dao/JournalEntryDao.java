/**
 * 
 */
package ru.urvanov.virtualpets.server.dao;

import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;

/**
 * @author fedya
 *
 */
public interface JournalEntryDao {
    JournalEntry findById(Integer id);
    JournalEntry findByCode(JournalEntryType code);
    JournalEntry getReference(Integer id);
}
