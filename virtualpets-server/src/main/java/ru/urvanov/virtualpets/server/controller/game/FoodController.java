package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.domain.GetPetDrinksResult;
import ru.urvanov.virtualpets.shared.domain.GetPetFoodsResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.DrinkService;
import ru.urvanov.virtualpets.shared.service.FoodService;

@RestController
@RequestMapping(value = "rest/v1/FoodService")
public class FoodController {
    @Autowired
    @Qualifier("foodRemoting")
    private FoodService foodRemoting;
    
    @GetMapping(value = "getPetFoods")
    public GetPetFoodsResult getPetFoods() throws DaoException, ServiceException {
        return foodRemoting.getPetFoods();
    }
}
