/**
 * 
 */
package ru.urvanov.virtualpets.shared.service;

import ru.urvanov.virtualpets.shared.domain.GetPetClothsResult;
import ru.urvanov.virtualpets.shared.domain.SavePetCloths;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

/**
 * @author fedya
 *
 */
public interface ClothService {
    public GetPetClothsResult getPetCloths() throws DaoException, ServiceException;;
    public void savePetCloths(SavePetCloths saveClothArg) throws DaoException, ServiceException;
}
