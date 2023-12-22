package ru.urvanov.virtualpets.shared.service;

import ru.urvanov.virtualpets.shared.domain.GetPetBooksResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

public interface BookService {
    GetPetBooksResult getPetBooks() throws DaoException, ServiceException;
}
