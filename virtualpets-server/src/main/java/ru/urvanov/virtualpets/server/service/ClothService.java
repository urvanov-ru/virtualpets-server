/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Cloth;

/**
 * @author fedya
 *
 */
public interface ClothService {
    public Cloth findById(Integer id);
    public Cloth getReference(Integer id);
    public Integer getCount();
}
