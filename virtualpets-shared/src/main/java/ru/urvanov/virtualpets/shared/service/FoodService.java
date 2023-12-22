/**
 * 
 */
package ru.urvanov.virtualpets.shared.service;

import ru.urvanov.virtualpets.shared.domain.GetPetFoodsResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

/**
 * @author fedya
 *
 */
public interface FoodService {
    public GetPetFoodsResult getPetFoods() throws DaoException, ServiceException;;
}
