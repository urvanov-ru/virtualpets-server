/**
 * 
 */
package ru.urvanov.virtualpets.server.dao;

import ru.urvanov.virtualpets.server.domain.BuildingMaterial;
import ru.urvanov.virtualpets.server.domain.BuildingMaterialType;

/**
 * @author fedya
 *
 */
public interface BuildingMaterialDao {
    public BuildingMaterial findById(Integer id);

    public BuildingMaterial findByCode(BuildingMaterialType iron);
}
