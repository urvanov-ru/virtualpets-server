package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.domain.GetPetDrinksResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.DrinkService;

@RestController
@RequestMapping(value = "rest/v1/DrinkService")
public class DrinkController {
    @Autowired
    @Qualifier("drinkRemoting")
    private DrinkService drinkRemoting;
    
    @GetMapping(value = "getPetDrinks")
    public GetPetDrinksResult getPetDrinks() throws DaoException, ServiceException {
        return drinkRemoting.getPetDrinks();
    }
}
