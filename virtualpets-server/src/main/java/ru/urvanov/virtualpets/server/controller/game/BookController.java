package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.shared.domain.GetPetBooksResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.BookService;

@RestController
@RequestMapping(value = "rest/v1/BookService")
public class BookController {
    @Autowired
    @Qualifier("bookRemoting")
    private BookService bookRemoting;
    
    @GetMapping(value = "getPetBooks")
    public GetPetBooksResult getPetBooks() throws DaoException, ServiceException {
        return bookRemoting.getPetBooks();
    }
}
