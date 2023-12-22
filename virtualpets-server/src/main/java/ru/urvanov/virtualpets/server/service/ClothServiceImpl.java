/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.ClothDao;
import ru.urvanov.virtualpets.server.domain.Cloth;



/**
 * @author fedya
 *
 */
@Service(value="clothService")
public class ClothServiceImpl implements ClothService {

    @Autowired
    private ClothDao clothDao;

    /**
     * @return the clothDao
     */
    public ClothDao getClothDao() {
        return clothDao;
    }

    /**
     * @param clothDao the clothDao to set
     */
    public void setClothDao(ClothDao clothDao) {
        this.clothDao = clothDao;
    }

    @Override
    public Cloth findById(Integer id) {
        return clothDao.findById(id);
    }

    @Override
    public Cloth getReference(Integer id) {
        return clothDao.getReference(id);
    }

    @Override
    public Integer getCount() {
        return clothDao.getCount();
    }
}
