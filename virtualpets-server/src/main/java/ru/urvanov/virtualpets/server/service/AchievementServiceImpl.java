package ru.urvanov.virtualpets.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.AchievementDao;
import ru.urvanov.virtualpets.server.domain.Achievement;
import ru.urvanov.virtualpets.server.domain.AchievementCode;

@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementDao achievementDao;
    
    @Override
    public Achievement findById(Integer id) {
        return achievementDao.findById(id);
    }

    @Override
    public Achievement findByCode(AchievementCode code) {
        return achievementDao.findByCode(code);
    }


    @Override
    public List<Achievement> findAll() {
        return achievementDao.findAll();
    }

}
