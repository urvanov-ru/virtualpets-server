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

import ru.urvanov.virtualpets.server.domain.Drink;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.PetDrink;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.server.service.PetService;
import ru.urvanov.virtualpets.shared.domain.GetPetDrinksResult;
/**
 * @author fedya
 *
 */
@Service(value="drinkRemoting")
public class DrinkRemoting implements ru.urvanov.virtualpets.shared.service.DrinkService {
    
    
    @Autowired
    private PetService petService;
    
    @Autowired
    private ConversionService conversionService;
    
    @Override
    public GetPetDrinksResult getPetDrinks() {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        Pet fullPet = petService.findFullById(selectedPet.getId());
        Map<Drink, PetDrink> drinks = fullPet.getDrinks();
        Map<ru.urvanov.virtualpets.shared.domain.DrinkType, Integer> drinkCounts = new HashMap<ru.urvanov.virtualpets.shared.domain.DrinkType, Integer>();
        for (PetDrink petDrink : drinks.values()) {
            ru.urvanov.virtualpets.shared.domain.DrinkType sharedDrinkType = conversionService.convert(petDrink.getDrink().getDrinkType(), ru.urvanov.virtualpets.shared.domain.DrinkType.class);
            drinkCounts.put(sharedDrinkType, petDrink.getDrinkCount());
        }
        ru.urvanov.virtualpets.shared.domain.GetPetDrinksResult result = new ru.urvanov.virtualpets.shared.domain.GetPetDrinksResult();
        result.setDrinkCounts(drinkCounts);
        return result;
    }



}
