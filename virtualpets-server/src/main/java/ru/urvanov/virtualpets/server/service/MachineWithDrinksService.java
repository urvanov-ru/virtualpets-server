/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.MachineWithDrinks;

/**
 * @author fedya
 *
 */
public interface MachineWithDrinksService {
    MachineWithDrinks findById(Integer id);
    MachineWithDrinks findFullById(Integer id);
}
