package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.domain.GetPetClothsResult;
import ru.urvanov.virtualpets.shared.domain.SavePetCloths;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.ClothService;

@RestController
@RequestMapping(value = "rest/v1/ClothService")
public class ClothController {
    @Autowired
    @Qualifier("clothRemoting")
    private ClothService clothRemoting;
    
    @GetMapping(value = "getPetCloths")
    public GetPetClothsResult getPetCloths() throws DaoException, ServiceException {
        return clothRemoting.getPetCloths();
    }
    
    @PostMapping(value = "savePetCloths")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void savePetCloth(SavePetCloths saveClothArg) throws DaoException, ServiceException {
        clothRemoting.savePetCloths(saveClothArg);
    }
}
