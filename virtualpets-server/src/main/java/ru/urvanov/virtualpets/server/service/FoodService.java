/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Food;
import ru.urvanov.virtualpets.server.domain.FoodType;

/**
 * @author fedya
 *
 */
public interface FoodService {
    public Food findById(Integer id);
    public Food findByCode(FoodType code);
}
