package ru.urvanov.virtualpets.server.service;

import java.util.List;

import ru.urvanov.virtualpets.server.domain.Achievement;
import ru.urvanov.virtualpets.server.domain.AchievementCode;

public interface AchievementService {

    public Achievement findById(Integer id);
    public Achievement findByCode(AchievementCode code);
    public List<Achievement> findAll();
}
