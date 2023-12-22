/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.RefrigeratorDao;
import ru.urvanov.virtualpets.server.domain.Refrigerator;

/**
 * @author fedya
 *
 */
@Service(value="refrigeratorService")
public class RefrigeratorServiceImpl implements RefrigeratorService {

    @Autowired
    private RefrigeratorDao refrigeratorDao;
    
    /**
     * 
     */
    public RefrigeratorServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Refrigerator findById(Integer id) {
        return refrigeratorDao.findById(id);
    }

    /**
     * @return the refrigeratorDao
     */
    public RefrigeratorDao getRefrigeratorDao() {
        return refrigeratorDao;
    }

    /**
     * @param refrigeratorDao the refrigeratorDao to set
     */
    public void setRefrigeratorDao(RefrigeratorDao refrigeratorDao) {
        this.refrigeratorDao = refrigeratorDao;
    }

    @Override
    public Refrigerator findFullById(Integer id) {
        return refrigeratorDao.findFullById(id);
    }

}
