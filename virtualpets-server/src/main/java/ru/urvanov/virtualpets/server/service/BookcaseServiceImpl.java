/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.BookcaseDao;
import ru.urvanov.virtualpets.server.domain.Bookcase;

/**
 * @author fedya
 *
 */
@Service(value="bookcaseService")
public class BookcaseServiceImpl implements BookcaseService {

    @Autowired
    private BookcaseDao bookcaseDao;

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.BookcaseService#findById(java.lang.Integer)
     */
    @Override
    public Bookcase findById(Integer id) {
        return bookcaseDao.findById(id);
    }

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.server.service.BookcaseService#findFullById(java.lang.Integer)
     */
    @Override
    public Bookcase findFullById(Integer id) {
        return bookcaseDao.findFullById(id);
    }

    /**
     * @return the bookcaseDao
     */
    public BookcaseDao getBookcaseDao() {
        return bookcaseDao;
    }

    /**
     * @param bookcaseDao the bookcaseDao to set
     */
    public void setBookcaseDao(BookcaseDao bookcaseDao) {
        this.bookcaseDao = bookcaseDao;
    }

}
