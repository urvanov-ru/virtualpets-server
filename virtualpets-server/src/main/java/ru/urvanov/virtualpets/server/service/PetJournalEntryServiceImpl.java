package ru.urvanov.virtualpets.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.urvanov.virtualpets.server.dao.PetJournalEntryDao;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;
import ru.urvanov.virtualpets.server.domain.PetJournalEntry;

@Service("petJournalEntryService")
public class PetJournalEntryServiceImpl implements PetJournalEntryService {

    @Autowired
    private PetJournalEntryDao petJournalEntryDao;
    
    @Transactional(readOnly=true)
    @Override
    public List<PetJournalEntry> findLastByPetId(Integer petId,
            Integer count) {
        return petJournalEntryDao.findLastByPetId(petId, count);
    }
    
    @Transactional(readOnly=true)
    @Override
    public PetJournalEntry findByPetIdAndJournalEntryCode(Integer petId,
            JournalEntryType code) {
        return petJournalEntryDao.findByPetIdAndJournalEntryCode(petId,
                code);
    }
    
    @Transactional
    @Override
    public void save(PetJournalEntry petJournalEntry) {
        petJournalEntryDao.save(petJournalEntry);
    }

}
