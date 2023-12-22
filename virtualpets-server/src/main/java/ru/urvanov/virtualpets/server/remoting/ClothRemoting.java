/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.Cloth;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.server.service.ClothService;
import ru.urvanov.virtualpets.server.service.PetService;
import ru.urvanov.virtualpets.shared.domain.GetPetClothsResult;
import ru.urvanov.virtualpets.shared.domain.SavePetCloths;

/**
 * @author fedya
 *
 */
@Service(value="clothRemoting")
public class ClothRemoting implements ru.urvanov.virtualpets.shared.service.ClothService {

    @Autowired
    private PetService petService;
    
    @Autowired
    private ClothService clothService;
    
    @Autowired
    private ConversionService conversionService;

    @Override
    public GetPetClothsResult getPetCloths() {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Set<Cloth> cloths = pet.getCloths();
        ru.urvanov.virtualpets.shared.domain.Cloth[] sharedCloths = new ru.urvanov.virtualpets.shared.domain.Cloth[cloths.size()];
        
        int n = 0;
        for (Cloth cloth : cloths) {
            ru.urvanov.virtualpets.shared.domain.Cloth sharedCloth = new ru.urvanov.virtualpets.shared.domain.Cloth();
            sharedCloth.setId(cloth.getId());
            sharedCloth.setClothType(conversionService.convert(cloth.getClothType(), ru.urvanov.virtualpets.shared.domain.ClothType.class));
            sharedCloths[n] = sharedCloth;
            n++;
        }

        ru.urvanov.virtualpets.shared.domain.GetPetClothsResult result = new ru.urvanov.virtualpets.shared.domain.GetPetClothsResult();
        result.setCloths(sharedCloths);
        Cloth hat = pet.getHat();
        Cloth cloth = pet.getCloth();
        Cloth bow = pet.getBow();
        if (hat != null) {
            result.setHatId(hat.getId());
        }
        if (cloth != null) {
            result.setClothId(cloth.getId());
        }
        if (bow != null) {
            result.setBowId(bow.getId());
        }
        return result;
    }
    
    @Override
    public void savePetCloths(SavePetCloths saveClothArg) {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findById(selectedPet.getId());
        Cloth hat = null;
        if (saveClothArg.getHatId() != null) {
            hat = clothService.getReference(saveClothArg.getHatId());
        }
        Cloth cloth = null;
        if (saveClothArg.getClothId() != null) {
            cloth = clothService.getReference(saveClothArg.getClothId());
        }
        Cloth bow = null;
        if (saveClothArg.getBowId() != null) {
            bow = clothService.getReference(saveClothArg.getBowId());
        }
        pet.setHat(hat);
        pet.setCloth(cloth);
        pet.setBow(bow);
        petService.save(pet);
    }
    
    /**
     * @return the petService
     */
    public PetService getPetService() {
        return petService;
    }


    /**
     * @param petService the petService to set
     */
    public void setPetService(PetService petService) {
        this.petService = petService;
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

    /**
     * @return the clothService
     */
    public ClothService getClothService() {
        return clothService;
    }

    /**
     * @param clothService the clothService to set
     */
    public void setClothService(ClothService clothService) {
        this.clothService = clothService;
    }
    
    
}
