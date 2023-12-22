/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Refrigerator;

/**
 * @author fedya
 *
 */
public interface RefrigeratorService {
    Refrigerator findById(Integer id);
    Refrigerator findFullById(Integer i);
}
