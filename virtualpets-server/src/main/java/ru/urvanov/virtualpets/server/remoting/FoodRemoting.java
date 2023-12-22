/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetFood;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.server.service.PetFoodService;
import ru.urvanov.virtualpets.shared.domain.GetPetFoodsResult;
/**
 * @author fedya
 *
 */
@Service(value="foodRemoting")
public class FoodRemoting implements ru.urvanov.virtualpets.shared.service.FoodService {

    @Autowired
    private PetFoodService petFoodService;
    
    @Autowired
    private ConversionService conversionService;
    
    @Override
    public GetPetFoodsResult getPetFoods() {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        List<PetFood> petFoods = petFoodService.findByPetId(selectedPet.getId());
        Map<ru.urvanov.virtualpets.shared.domain.FoodType, Integer> foodCounts = new HashMap<ru.urvanov.virtualpets.shared.domain.FoodType, Integer>();
        for (PetFood petFood : petFoods) {
            ru.urvanov.virtualpets.shared.domain.FoodType sharedFoodType = conversionService.convert(petFood.getFood().getCode(), ru.urvanov.virtualpets.shared.domain.FoodType.class);
            foodCounts.put(sharedFoodType, petFood.getFoodCount());
        }
        ru.urvanov.virtualpets.shared.domain.GetPetFoodsResult result = new ru.urvanov.virtualpets.shared.domain.GetPetFoodsResult();
        result.setFoodCounts(foodCounts);
        return result;
    }


    /**
     * @return the petFoodService
     */
    public PetFoodService getPetFoodService() {
        return petFoodService;
    }


    /**
     * @param petFoodService the petFoodService to set
     */
    public void setPetFoodService(PetFoodService petFoodService) {
        this.petFoodService = petFoodService;
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
