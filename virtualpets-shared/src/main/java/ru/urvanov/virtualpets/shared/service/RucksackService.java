/**
 * 
 */
package ru.urvanov.virtualpets.shared.service;

import ru.urvanov.virtualpets.shared.domain.GetPetRucksackInnerResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

/**
 * @author fedya
 *
 */
public interface RucksackService {
    public GetPetRucksackInnerResult getPetRucksackInner() throws DaoException, ServiceException;
}
