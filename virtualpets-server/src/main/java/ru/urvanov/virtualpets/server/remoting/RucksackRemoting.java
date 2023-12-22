/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.BuildingMaterial;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetBuildingMaterial;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.shared.domain.GetPetRucksackInnerResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.RucksackService;

/**
 * @author fedya
 *
 */
@Service (value = "rucksackRemoting")
public class RucksackRemoting implements RucksackService {
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.PetService petService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.RoomService roomService;
    
    @Autowired
    private ConversionService conversionService;
    
    @Override
    public GetPetRucksackInnerResult getPetRucksackInner()
            throws DaoException, ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        Pet fullPet = petService.findFullById(selectedPet.getId());
        Map<BuildingMaterial, PetBuildingMaterial> buildingMaterials = fullPet.getBuildingMaterials();
        Map<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer> buildMaterialCounts = new HashMap<ru.urvanov.virtualpets.shared.domain.BuildingMaterialType, Integer>();
        for (PetBuildingMaterial bm : buildingMaterials.values()) {
            ru.urvanov.virtualpets.shared.domain.BuildingMaterialType sharedBuildMaterialType = conversionService.convert(bm.getBuildingMaterial().getCode(), ru.urvanov.virtualpets.shared.domain.BuildingMaterialType.class);
            buildMaterialCounts.put(sharedBuildMaterialType, bm.getBuildingMaterialCount());
        }
        ru.urvanov.virtualpets.shared.domain.GetPetRucksackInnerResult result = new ru.urvanov.virtualpets.shared.domain.GetPetRucksackInnerResult();
        result.setBuildingMaterialCounts(buildMaterialCounts);
        return result;
    }

 
    /**
     * @return the petService
     */
    public ru.urvanov.virtualpets.server.service.PetService getPetService() {
        return petService;
    }


    /**
     * @param petService the petService to set
     */
    public void setPetService(
            ru.urvanov.virtualpets.server.service.PetService petService) {
        this.petService = petService;
    }


    /**
     * @return the roomService
     */
    public ru.urvanov.virtualpets.server.service.RoomService getRoomService() {
        return roomService;
    }


    /**
     * @param roomService the roomService to set
     */
    public void setRoomService(
            ru.urvanov.virtualpets.server.service.RoomService roomService) {
        this.roomService = roomService;
    }


    /**
     * @return the conversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * @param conversionService the conversionService to set
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

}
