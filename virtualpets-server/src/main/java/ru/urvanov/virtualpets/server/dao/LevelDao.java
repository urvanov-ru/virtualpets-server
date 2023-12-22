package ru.urvanov.virtualpets.server.dao;

import java.util.List;

import ru.urvanov.virtualpets.server.domain.Level;

public interface LevelDao {
    Level findById(Integer id);
    
    List<Level> findAll();
}
