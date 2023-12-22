/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.UserDao;
import ru.urvanov.virtualpets.server.domain.User;

/**
 * @author fedya
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @return the userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * @param userDao
     *            the userDao to set
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userDao.findByLoginAndPassword(login, password);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findOnline() {
        return userDao.findOnline();
    }

    @Override
    public User findByLoginAndEmail(String login, String email) {
        return userDao.findByLoginAndEmail(login, email);
    }

    @Override
    public User findByFacebookKey(String facebookKey) {
        return userDao.findByFacebookKey(facebookKey);
    }

    @Override
    public User findByUnid(String unid) {
        return userDao.findByUnid(unid);
    }

    @Override
    public User findByRecoverPasswordKey(String recoverKey) {
        if ((recoverKey == null) || (recoverKey.equals(""))) {
            throw new IllegalArgumentException();
        }
        return userDao.findByRecoverPasswordKey(recoverKey);
    }

    @Override
    public User findByVkontakteKey(String vkontakteKey) {
        return userDao.findByVkontakteKey(vkontakteKey);
    }

    @Override
    public User findByTwitterKey(String twitterKey) {
        return userDao.findByTwitterKey(twitterKey);
    }

    @Override
    public List<User> findLastRegisteredUsers(int start, int limit) {
        return userDao.findLastRegisteredUsers(start, limit);
    }

    @Override
    public User getReference(Integer id) {
        return userDao.getReference(id);
    }
}
