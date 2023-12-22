package ru.urvanov.virtualpets.server.controller.site;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.urvanov.virtualpets.server.domain.Achievement;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.service.AchievementService;
import ru.urvanov.virtualpets.server.service.PetService;

@Controller
@RequestMapping("site")
public class PetController {

    private static final Logger logger = LoggerFactory
            .getLogger(PetController.class);

    @Autowired
    private PetService petService;

    @Autowired
    private AchievementService achievementService;

    @RequestMapping(value = "/information/pet", method = RequestMethod.GET)
    public String petInfo(@RequestParam(value = "id") Integer id, Model model) {
        logger.info("/information/pet started.");
        Pet fullPet = petService.findFullById(id);
        List<Achievement> allAchievements = achievementService.findAll();
        model.addAttribute("fullPet", fullPet);
        model.addAttribute("allAchievements", allAchievements);
        logger.info("/information/pet finished.");
        return "information/pet";
    }

}
