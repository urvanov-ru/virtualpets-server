/**
 * 
 */
package ru.urvanov.virtualpets.shared.service;

import ru.urvanov.virtualpets.shared.domain.GetPetDrinksResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

/**
 * @author fedya
 *
 */
public interface DrinkService {
    public GetPetDrinksResult getPetDrinks() throws DaoException, ServiceException;;
}
