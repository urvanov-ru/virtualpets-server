package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.domain.GetPetRucksackInnerResult;
import ru.urvanov.virtualpets.shared.domain.GetRoomInfoResult;
import ru.urvanov.virtualpets.shared.domain.OpenBoxNewbieResult;
import ru.urvanov.virtualpets.shared.domain.RoomBuildMenuCosts;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.RoomService;
import ru.urvanov.virtualpets.shared.service.RucksackService;

@RestController
@RequestMapping(value = "rest/v1/RucksackService")
public class RucksackController {
    
    @Autowired
    @Qualifier("rucksackRemoting")
    private RucksackService rucksackRemoting;
    
    @GetMapping(value = "getPetRucksackInner")
    public GetPetRucksackInnerResult getPetRucksackInner() throws DaoException, ServiceException {
        return rucksackRemoting.getPetRucksackInner();
    }

}
