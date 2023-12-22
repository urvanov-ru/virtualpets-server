/**
 * 
 */
package ru.urvanov.virtualpets.server.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.urvanov.virtualpets.server.remoting.PublicRemoting;
import ru.urvanov.virtualpets.shared.domain.GetServersArg;
import ru.urvanov.virtualpets.shared.domain.LoginResult;
import ru.urvanov.virtualpets.shared.domain.RecoverPasswordArg;
import ru.urvanov.virtualpets.shared.domain.RecoverPasswordResult;
import ru.urvanov.virtualpets.shared.domain.RecoverSessionArg;
import ru.urvanov.virtualpets.shared.domain.RegisterArgument;
import ru.urvanov.virtualpets.shared.domain.ServerInfo;
import ru.urvanov.virtualpets.shared.domain.ServerTechnicalInfo;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.PublicService;

/**
 * @author fedya
 * 
 */
@RestController
@RequestMapping(value = "rest/v1/PublicService")
public class PublicController {

    @Autowired
    public PublicRemoting publicRemoting;
    

    @RequestMapping(method = RequestMethod.GET, value="servers")
    public ServerInfo[] getServers(@RequestParam(name="version") String version) throws ServiceException,
            DaoException {
        GetServersArg arg = new GetServersArg();
        arg.setVersion(version);
        return publicRemoting.getServers(arg);
    }

    @RequestMapping(method=RequestMethod.POST, value="register")
    public void register(@RequestBody RegisterArgument arg) throws ServiceException {
        publicRemoting.register(arg);
    }

    @RequestMapping(method = RequestMethod.POST, value="recoverPassword")
    public RecoverPasswordResult recoverPassword(RecoverPasswordArg argument)
            throws ServiceException {
        return publicRemoting.recoverPassword(argument);
    }

    @RequestMapping(method = RequestMethod.POST, value = "recoverSession")
    public LoginResult recoverSession(RecoverSessionArg arg)
            throws ServiceException, DaoException {
        return publicRemoting.recoverSession(arg);
    }

    @RequestMapping(method = RequestMethod.GET, value="server-technical-info")
    public ServerTechnicalInfo getServerTechnicalInfo()
            throws ServiceException, DaoException {
        return publicRemoting.getServerTechnicalInfo();
    }

}
