/**
 * 
 */
package ru.urvanov.virtualpets.server.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.urvanov.virtualpets.server.domain.User;
import ru.urvanov.virtualpets.server.test.annotation.DataSets;

/**
 * @author fedya
 * 
 */
public class UserServiceImplTest extends AbstractServiceImplTest {

    @Autowired
    private UserService userService;

    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/UserServiceImplTest.xls")
    @Test
    public void findByName() throws Exception {
        User user = userService.findByLogin("Clarence");
        assertNotNull(user);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/UserServiceImplTest.xls")
    @Test
    public void findLastRegisteredUsers() throws Exception {
        List<User> users = userService.findLastRegisteredUsers(0, 999999);
        assertEquals(users.size(), 1);
    }

    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService
     *            the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
