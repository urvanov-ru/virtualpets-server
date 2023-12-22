/**
 * 
 */
package ru.urvanov.virtualpets.server.dao;

import ru.urvanov.virtualpets.server.domain.MachineWithDrinks;

/**
 * @author fedya
 *
 */
public interface MachineWithDrinksDao {
    MachineWithDrinks findById(Integer id);
    MachineWithDrinks findFullById(Integer id);
}
