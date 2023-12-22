/**
 * 
 */
package ru.urvanov.virtualpets.server.convserv;

import org.springframework.core.convert.converter.Converter;

import ru.urvanov.virtualpets.server.domain.DrinkType;

/**
 * @author fedya
 *
 */
public class DrinkTypeSharedToServerConverter implements Converter<ru.urvanov.virtualpets.shared.domain.DrinkType, ru.urvanov.virtualpets.server.domain.DrinkType> {

    @Override
    public DrinkType convert(
            ru.urvanov.virtualpets.shared.domain.DrinkType source) {
        return ru.urvanov.virtualpets.server.domain.DrinkType.valueOf(source.name());
    }

}
