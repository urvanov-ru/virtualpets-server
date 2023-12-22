package ru.urvanov.virtualpets.server.remoting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.shared.domain.GetPetJournalEntriesResult;

@Service("journalEntryRemoting")
public class JournalEntryRemoting implements ru.urvanov.virtualpets.shared.service.JournalEntryService {

    
    @Autowired
    private ConversionService conversionService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.PetJournalEntryService petJournalEntryService;
    
    @Override
    public GetPetJournalEntriesResult getPetJournalEntries(int count) {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        List<ru.urvanov.virtualpets.server.domain.PetJournalEntry> serverPetJournalEntries = petJournalEntryService.findLastByPetId(selectedPet.getId(), count);
        GetPetJournalEntriesResult result = new GetPetJournalEntriesResult();
        ru.urvanov.virtualpets.shared.domain.PetJournalEntry[] sharedEntries = new ru.urvanov.virtualpets.shared.domain.PetJournalEntry[serverPetJournalEntries.size()];
        for (int n = 0; n < serverPetJournalEntries.size(); n++) {
            ru.urvanov.virtualpets.server.domain.PetJournalEntry serverPetJournalEntry = serverPetJournalEntries.get(n);
            serverPetJournalEntry.setReaded(true);
            petJournalEntryService.save(serverPetJournalEntry);
            int sharedIndex = serverPetJournalEntries.size() - 1 - n;
            sharedEntries[sharedIndex] = new ru.urvanov.virtualpets.shared.domain.PetJournalEntry();
            sharedEntries[sharedIndex].setCode(conversionService.convert(serverPetJournalEntry.getJournalEntry().getCode(), ru.urvanov.virtualpets.shared.domain.JournalEntryType.class));
            sharedEntries[sharedIndex].setCreatedAt(serverPetJournalEntry.getCreatedAt());
        }
        
        result.setEntries(sharedEntries);
        
        
        return result;
    }



}
