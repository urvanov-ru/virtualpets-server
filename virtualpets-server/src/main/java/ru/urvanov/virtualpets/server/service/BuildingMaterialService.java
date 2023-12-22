/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.BuildingMaterial;
import ru.urvanov.virtualpets.server.domain.BuildingMaterialType;

/**
 * @author fedya
 *
 */
public interface BuildingMaterialService {
    public BuildingMaterial findById(Integer id);

    public BuildingMaterial findByCode(BuildingMaterialType iron);
}
