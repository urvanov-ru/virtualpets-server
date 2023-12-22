package ru.urvanov.virtualpets.server.service;

import java.util.List;

import ru.urvanov.virtualpets.server.domain.JournalEntryType;
import ru.urvanov.virtualpets.server.domain.PetJournalEntry;

public interface PetJournalEntryService {
    List<PetJournalEntry> findLastByPetId(Integer petId, Integer count);

    PetJournalEntry findByPetIdAndJournalEntryCode(Integer id,
            JournalEntryType openNewbieBoxes);

    void save(PetJournalEntry serverPetJournalEntry);
}
