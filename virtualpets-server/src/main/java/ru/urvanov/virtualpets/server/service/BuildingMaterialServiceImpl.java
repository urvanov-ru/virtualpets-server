/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.BuildingMaterialDao;
import ru.urvanov.virtualpets.server.domain.BuildingMaterial;
import ru.urvanov.virtualpets.server.domain.BuildingMaterialType;

/**
 * @author fedya
 *
 */
@Service(value="buildingMaterialService")
public class BuildingMaterialServiceImpl implements BuildingMaterialService {

    @Autowired
    private BuildingMaterialDao buildingMaterialDao;
    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.BuildingMaterialService#findById(java.lang.Integer)
     */
    @Override
    public BuildingMaterial findById(Integer id) {
        return buildingMaterialDao.findById(id);
    }
    /**
     * @return the buildingMaterialDao
     */
    public BuildingMaterialDao getBuildingMaterialDao() {
        return buildingMaterialDao;
    }
    /**
     * @param buildingMaterialDao the buildingMaterialDao to set
     */
    public void setBuildingMaterialDao(BuildingMaterialDao buildingMaterialDao) {
        this.buildingMaterialDao = buildingMaterialDao;
    }
    @Override
    public BuildingMaterial findByCode(BuildingMaterialType iron) {
        return buildingMaterialDao.findByCode(iron);
    }

}
