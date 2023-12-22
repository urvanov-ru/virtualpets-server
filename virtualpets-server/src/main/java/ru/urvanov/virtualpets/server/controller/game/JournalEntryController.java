package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.domain.GetPetJournalEntriesResult;
import ru.urvanov.virtualpets.shared.service.JournalEntryService;

@RestController
@RequestMapping(value = "rest/v1/JournalEntryService")
public class JournalEntryController {
    
    @Autowired
    @Qualifier("journalEntryRemoting")
    private  JournalEntryService journalEntryRemoting;
    
    @RequestMapping(method = RequestMethod.GET, value = "getPetJournalEntries")
    public GetPetJournalEntriesResult getPetJournalEntries(@RequestParam(name = "count") int count) {
        return this.journalEntryRemoting.getPetJournalEntries(count);
    }
    

}
