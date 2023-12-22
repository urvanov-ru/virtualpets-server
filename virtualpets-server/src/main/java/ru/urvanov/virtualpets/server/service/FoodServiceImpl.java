/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.FoodDao;
import ru.urvanov.virtualpets.server.domain.Food;
import ru.urvanov.virtualpets.server.domain.FoodType;

/**
 * @author fedya
 *
 */
@Service(value = "foodService")
public class FoodServiceImpl implements FoodService {
    
    @Autowired
    private FoodDao foodDao;
    
    @Override
    public Food findById(Integer id) {
        return foodDao.findById(id);
    }

    /**
     * @return the foodDao
     */
    public FoodDao getFoodDao() {
        return foodDao;
    }

    /**
     * @param foodDao the foodDao to set
     */
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public Food findByCode(FoodType code) {
        return foodDao.findByCode(code);
    }

}
