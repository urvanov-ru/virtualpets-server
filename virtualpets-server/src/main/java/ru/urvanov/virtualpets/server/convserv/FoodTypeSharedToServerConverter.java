/**
 * 
 */
package ru.urvanov.virtualpets.server.convserv;

import org.springframework.core.convert.converter.Converter;

import ru.urvanov.virtualpets.server.domain.FoodType;

/**
 * @author fedya
 *
 */
public class FoodTypeSharedToServerConverter implements Converter<ru.urvanov.virtualpets.shared.domain.FoodType, ru.urvanov.virtualpets.server.domain.FoodType> {

    @Override
    public FoodType convert(
            ru.urvanov.virtualpets.shared.domain.FoodType source) {
        return ru.urvanov.virtualpets.server.domain.FoodType.valueOf(source.name());
    }

}
