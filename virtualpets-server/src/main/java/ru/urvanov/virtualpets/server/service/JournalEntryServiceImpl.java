/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.JournalEntryDao;
import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;

/**
 * @author fedya
 *
 */
@Service("journalEntryService")
public class JournalEntryServiceImpl implements JournalEntryService {

    
    @Autowired
    private JournalEntryDao journalEntryDao;
    
    @Override
    public JournalEntry findById(Integer id) {
        return journalEntryDao.findById(id);
    }

    @Override
    public JournalEntry findByCode(JournalEntryType code) {
        return journalEntryDao.findByCode(code);
    }

    @Override
    public JournalEntry getReference(Integer id) {
        return journalEntryDao.getReference(id);
    }

}
