package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Drink;
import ru.urvanov.virtualpets.server.domain.DrinkType;

public interface DrinkService {
    public Drink findById(Integer id);
    public Drink getReference(Integer id);
    public Drink findByCode(DrinkType code);
}
