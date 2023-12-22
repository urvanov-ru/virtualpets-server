package ru.urvanov.virtualpets.server.controller.game;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.service.PetService;
import ru.urvanov.virtualpets.shared.domain.CreatePetArg;
import ru.urvanov.virtualpets.shared.domain.CreatePetResult;
import ru.urvanov.virtualpets.shared.domain.DrinkArg;
import ru.urvanov.virtualpets.shared.domain.PetListResult;
import ru.urvanov.virtualpets.shared.domain.SatietyArg;
import ru.urvanov.virtualpets.shared.domain.SelectPetArg;
import ru.urvanov.virtualpets.shared.domain.SelectPetResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

@RestController("restPetController")
@RequestMapping("rest/v1/PetService")
public class PetController {
    
    @Autowired
    @Qualifier("petRemoting")
    private PetService petRemoting;
    
    @RequestMapping(value = "getUserPets", method = RequestMethod.GET)
    public PetListResult getUserPets() throws DaoException,
            ServiceException {
        return petRemoting.getUserPets();
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreatePetResult create(@RequestBody CreatePetArg createPetArg) throws DaoException,
            ServiceException {
        return petRemoting.create(createPetArg);
    }
    
    @RequestMapping(value = "select", method = RequestMethod.POST)
    public SelectPetResult select(@RequestBody SelectPetArg selectPetArg) throws DaoException,
            ServiceException {
        return petRemoting.select(selectPetArg);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "drink", method = RequestMethod.POST)
    public void drink(@RequestBody DrinkArg drinkArg) throws DaoException,
            ServiceException {
        petRemoting.drink(drinkArg);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "satiety", method = RequestMethod.POST)
    public void eat(@RequestBody SatietyArg satietyArg) throws DaoException,
            ServiceException {
        petRemoting.satiety(satietyArg);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "education", method = RequestMethod.POST)
    public void education() throws DaoException,
            ServiceException {
        petRemoting.education();
    }

}


