/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import java.util.List;

import ru.urvanov.virtualpets.server.domain.User;

/**
 * @author fedya
 *
 */
public interface UserService {

    public List<User> list();
    
    public User findById(Integer id);

    public User findByLogin(String name);
    
    public User findByLoginAndPassword(String login, String password);

    public void save(User user);

    public List<User> findOnline();

    public User findByLoginAndEmail(String login, String email);

    public User findByFacebookKey(String providerUserId);

    public User findByUnid(String unid);

    public User findByRecoverPasswordKey(String recoverKey);

    public User findByVkontakteKey(String vkontakteKey);

    public User findByTwitterKey(String twitterKey);

    public List<User> findLastRegisteredUsers(int start, int limit);

    public User getReference(Integer id);
}
