package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.DrinkDao;
import ru.urvanov.virtualpets.server.domain.Drink;
import ru.urvanov.virtualpets.server.domain.DrinkType;

@Service("drinkService")
public class DrinkServiceImpl implements DrinkService {
    
    @Autowired
    private DrinkDao drinkDao;

    @Override
    public Drink findById(Integer id) {
        return drinkDao.findById(id);
    }

    @Override
    public Drink getReference(Integer id) {
        return drinkDao.getReference(id);
    }

    @Override
    public Drink findByCode(DrinkType code) {
        return drinkDao.findByCode(code);
    }
    
    
}
