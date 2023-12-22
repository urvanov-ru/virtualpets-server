package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Bookcase;

public interface BookcaseService {
    Bookcase findById(Integer id);
    Bookcase findFullById(Integer id);
}
