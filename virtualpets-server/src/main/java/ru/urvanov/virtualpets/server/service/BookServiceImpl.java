package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.urvanov.virtualpets.server.dao.BookDao;
import ru.urvanov.virtualpets.server.domain.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional(readOnly=true)
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }
    
    
}
