/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.User;
import ru.urvanov.virtualpets.shared.domain.LoginArg;
import ru.urvanov.virtualpets.shared.domain.LoginResult;
import ru.urvanov.virtualpets.shared.domain.RefreshUsersOnlineArg;
import ru.urvanov.virtualpets.shared.domain.RefreshUsersOnlineResult;
import ru.urvanov.virtualpets.shared.domain.UserInfo;
import ru.urvanov.virtualpets.shared.domain.UserInformation;
import ru.urvanov.virtualpets.shared.domain.UserInformationArg;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.IncompatibleVersionException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;

/**
 * @author fedya
 *
 */
@Service("userRemoting")
public class UserRemoting implements ru.urvanov.virtualpets.shared.service.UserService{

    @Autowired
    private ru.urvanov.virtualpets.server.service.UserService userService;
    
    @Autowired
    private ConversionService conversionService;
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private String version;
    
    @Override
    public LoginResult login(LoginArg arg) throws ServiceException, DaoException {
        String clientVersion = arg.getVersion();
        if (!version.equals(clientVersion)) {
            throw new IncompatibleVersionException("", version, clientVersion);
        }
        org.springframework.web.context.request.ServletRequestAttributes sra = (org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
        sra.setAttribute("my1", "var1", ServletRequestAttributes.SCOPE_SESSION);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User)authentication.getPrincipal();
        user = userService.findById(user.getId());
        
        byte[] b = new byte[256];
        Random r = new Random();
        r.nextBytes(b);
        String uniqueIdentifier = Base64.encodeBase64String(b);
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        uniqueIdentifier = uniqueIdentifier + f.format(d);
        user.setUnid(uniqueIdentifier);
        userService.save(user);
        
        LoginResult loginResult = new LoginResult();
        loginResult.setUnid(uniqueIdentifier);
        loginResult.setUserId(user.getId());
        loginResult.setSuccess(true);
        return loginResult;
    }

    @Override
    public RefreshUsersOnlineResult getUsersOnline(
            RefreshUsersOnlineArg argument) {
        List<User> users = userService.findOnline();
        UserInfo[] userInfos = new UserInfo[users.size()];
        int n = 0;
        for (User u : users) {
            userInfos[n] = new UserInfo();
            userInfos[n].setId(u.getId());
            userInfos[n].setName(u.getName());
            n++;
        }
        RefreshUsersOnlineResult result = new RefreshUsersOnlineResult();
        result.setSuccess(true);
        result.setUsers(userInfos);
        return result;
    }

    @Override
    @Transactional
    public UserInformation getUserInformation(UserInformationArg argument) {
        Integer userId = argument.getUserId();
        User user = userService.findById(userId);
        UserInformation result = new UserInformation();
        result.setId(userId);
        result.setName(user.getName());
        result.setBirthdate(user.getBirthdate());
        result.setCity(user.getCity());
        result.setCountry(user.getCountry());
        result.setComment(user.getComment());
        //result.setPhoto(user.getPhoto());
        if (user.getSex() != null) {
            result.setSex(conversionService.convert(user.getSex(), ru.urvanov.virtualpets.shared.domain.Sex.class));
        }
        return result;
    }

    /**
     * @return the userService
     */
    public ru.urvanov.virtualpets.server.service.UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(
            ru.urvanov.virtualpets.server.service.UserService userService) {
        this.userService = userService;
    }



    /**
     * @return the conversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }



    /**
     * @param conversionService the conversionService to set
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }



    @Override
    public void closeSession() throws DaoException, ServiceException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User)authentication.getPrincipal();
        user = userService.findById(user.getId());
        user.setUnid(null);
        userService.save(user);
    }



    /**
     * @return the messageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }



    /**
     * @param messageSource the messageSource to set
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }



    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }



    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }



    @Override
    public void updateUserInformation(UserInformation arg)
            throws ServiceException, DaoException {
        byte[] photo = arg.getPhoto();
        if (photo!= null) {
            if (photo.length > 100000) {
                throw new ServiceException("Too big file.");
            }
        }
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth= context.getAuthentication();
        User user = (User) auth.getPrincipal();
        Integer id = user.getId();
        if (id.equals(arg.getId())) {
            user = userService.findById(id);
            user.setName(arg.getName());
            user.setSex(conversionService.convert(arg.getSex(), ru.urvanov.virtualpets.server.domain.Sex.class));
            user.setBirthdate(arg.getBirthdate());
            user.setCountry(arg.getCountry());
            user.setCity(arg.getCity());
            user.setComment(arg.getComment());
            //user.setPhoto(arg.getPhoto());
            userService.save(user);
        } else {
            throw new ServiceException("Incorrect user id. You can not save this user information.");
        }
    }
    
    
}
