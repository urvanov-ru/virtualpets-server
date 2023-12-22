package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;

public interface JournalEntryService {
    JournalEntry findById(Integer id);
    JournalEntry findByCode(JournalEntryType code);
    JournalEntry getReference(Integer id);
}
