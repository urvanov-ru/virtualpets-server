/**
 * 
 */
package ru.urvanov.virtualpets.shared.service;

import ru.urvanov.virtualpets.shared.domain.CreatePetArg;
import ru.urvanov.virtualpets.shared.domain.CreatePetResult;
import ru.urvanov.virtualpets.shared.domain.DrinkArg;
import ru.urvanov.virtualpets.shared.domain.PetListResult;
import ru.urvanov.virtualpets.shared.domain.SatietyArg;
import ru.urvanov.virtualpets.shared.domain.SelectPetArg;
import ru.urvanov.virtualpets.shared.domain.SelectPetResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

/**
 * @author fedya
 *
 */
public interface PetService {
    public PetListResult getUserPets() throws DaoException, ServiceException;
    public CreatePetResult create(CreatePetArg arg) throws DaoException, ServiceException;
    public SelectPetResult select(SelectPetArg arg) throws DaoException, ServiceException;
    public void drink(DrinkArg arg) throws DaoException, ServiceException;
    public void satiety(SatietyArg satietyArg) throws DaoException, ServiceException;
    public void education() throws DaoException, ServiceException;
    public void mood() throws DaoException, ServiceException;
}
