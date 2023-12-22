package ru.urvanov.virtualpets.server.remoting;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.Achievement;
import ru.urvanov.virtualpets.server.domain.AchievementCode;
import ru.urvanov.virtualpets.server.domain.JournalEntry;
import ru.urvanov.virtualpets.server.domain.JournalEntryType;
import ru.urvanov.virtualpets.server.domain.Level;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetJournalEntry;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.shared.domain.GetTownInfoResult;
import ru.urvanov.virtualpets.shared.domain.LevelInfo;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.TownService;

@Service("townRemoting")
public class TownRemoting implements TownService {

    @Autowired
    private ru.urvanov.virtualpets.server.service.PetService petService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.LevelService levelService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.JournalEntryService journalEntryService;

    @Autowired
    private ru.urvanov.virtualpets.server.service.AchievementService achievementService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public GetTownInfoResult getTownInfo() throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet",
                ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());

        Map<JournalEntry, PetJournalEntry> mapJournalEntries = pet
                .getJournalEntries();
        JournalEntry playHiddenObjectGames = journalEntryService
                .findByCode(JournalEntryType.PLAY_HIDDEN_OBJECT_GAMES);
        if (!mapJournalEntries.containsKey(playHiddenObjectGames)) {
            PetJournalEntry petJournalEntry = new PetJournalEntry();
            petJournalEntry.setCreatedAt(new Date());
            petJournalEntry.setPet(pet);
            petJournalEntry.setJournalEntry(playHiddenObjectGames);
            mapJournalEntries.put(playHiddenObjectGames, petJournalEntry);
        }

        Achievement leaveTownAchievement = achievementService
                .findByCode(AchievementCode.LEAVE_ROOM);
        petService.addAchievementIfNot(pet, leaveTownAchievement);
        
        petService.addExperience(petService.findFullById(pet.getId()), 1);
        
        GetTownInfoResult result = new GetTownInfoResult();

        LevelInfo levelInfo = new LevelInfo();
        result.setLevelInfo(levelInfo);
        levelInfo.setLevel(pet.getLevel().getId());
        levelInfo.setExperience(pet.getExperience());
        Level nextLevelLeague = levelService
                .findById(pet.getLevel().getId() + 1);
        levelInfo.setMaxExperience(nextLevelLeague == null ? Integer.MAX_VALUE
                : nextLevelLeague.getExperience());
        levelInfo.setMinExperience(pet.getLevel().getExperience());

        List<AchievementCode> listServerAchievements = petService
                .calculateAchievements(pet);
        ru.urvanov.virtualpets.shared.domain.AchievementCode[] listSharedAchievements = new ru.urvanov.virtualpets.shared.domain.AchievementCode[listServerAchievements
                .size()];
        int n = 0;
        for (AchievementCode ac : listServerAchievements) {
            listSharedAchievements[n] = conversionService
                    .convert(
                            ac,
                            ru.urvanov.virtualpets.shared.domain.AchievementCode.class);
            n++;
        }
        result.setAchievements(listSharedAchievements);

        result.setNewJournalEntriesCount(petService
                .getPetNewJournalEntriesCount(pet.getId()));
        petService.save(pet);
        return result;
    }

}
