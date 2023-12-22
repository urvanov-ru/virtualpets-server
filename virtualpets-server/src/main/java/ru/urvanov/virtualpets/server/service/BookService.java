package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Book;

public interface BookService {
    Book findById(Integer id);
}
