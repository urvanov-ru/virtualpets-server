/**
 * 
 */
package ru.urvanov.virtualpets.server.controller.site;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.social.facebook.api.Facebook;
//import org.springframework.social.facebook.api.FacebookProfile;
//import org.springframework.social.twitter.api.Twitter;
//import org.springframework.social.twitter.api.TwitterProfile;
//import org.springframework.social.vkontakte.api.VKontakte;
//import org.springframework.social.vkontakte.api.VKontakteDate;
//import org.springframework.social.vkontakte.api.VKontakteProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.urvanov.virtualpets.server.domain.User;
import ru.urvanov.virtualpets.server.service.UserService;

/**
 * @author fedya
 *
 */
@Controller
@RequestMapping("site")
public class ProfileController {
    private static final Logger logger = LoggerFactory
            .getLogger(ProfileController.class);

    @Autowired
    private UserService userService;

//    private final Facebook facebook;
//    
//    private final VKontakte vkontakte;
//    
//    private final Twitter twitter;
    
//    @Inject
//    public ProfileController(Facebook facebook, VKontakte vkontakte,
//            Twitter twitter) {
//        this.facebook = facebook;
//        this.vkontakte = vkontakte;
//        this.twitter = twitter;
//    }

    /**
     * Получает данные от социальной сети и сохраняет в пользователях игры.
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest request) {
        logger.info("Welcome home! The client locale is {}.", locale);
        // String socialtype = (String) request.getSession().getAttribute("socialtype");
        String email = "";
        String name = "";
        String birthdate = "";
        
//        if (socialtype.equals("facebook")) {
//            FacebookProfile profile = facebook.userOperations().getUserProfile();
//            email = profile.getEmail();
//            name = profile.getName();
//            birthdate = profile.getBirthday();
//        } else if (socialtype.equals("vkontakte")) {
//            VKontakteProfile profile = vkontakte.usersOperations().getProfile();
//            name = profile.getFirstName() + " " + profile.getLastName();
//            VKontakteDate vkontakteDate = profile.getBirthDate();
//            if (vkontakteDate != null) {
//                birthdate = vkontakteDate.toString();
//            }
//        } else if (socialtype.equals("twitter")) {
//            TwitterProfile profile = twitter.userOperations().getUserProfile();
//            name = profile.getName();
//        }

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String authStr = "Not authenticated";
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal != null) {
                authStr = authentication.getPrincipal().toString();
                if (principal instanceof User) {
                    User user = (User) principal;
                    user = userService.findById(user.getId());
                    String unid = (String) request.getSession().getAttribute("unid");
                    user.setUnid(unid);
                    user.setEmail(email);
                    user.setName(name);
                    userService.save(user);
                }
            }
        }
        model.addAttribute("authStr", authStr);

        
        model.addAttribute("email", email);
        model.addAttribute("name", name);
        model.addAttribute("birthdate", birthdate);
        return "profile";
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
