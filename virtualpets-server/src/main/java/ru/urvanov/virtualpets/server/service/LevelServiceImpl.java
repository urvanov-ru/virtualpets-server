package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.LevelDao;
import ru.urvanov.virtualpets.server.domain.Level;

@Service("levelService")
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelDao levelLeagueDao;

    @Override
    public Level findById(int id) {
        return levelLeagueDao.findById(id);
    }
    
    

}
