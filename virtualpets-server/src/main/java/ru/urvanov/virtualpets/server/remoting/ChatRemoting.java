/**
 * 
 */
package ru.urvanov.virtualpets.server.remoting;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.domain.Chat;
import ru.urvanov.virtualpets.server.domain.User;
import ru.urvanov.virtualpets.shared.domain.ChatMessage;
import ru.urvanov.virtualpets.shared.domain.RefreshChatArg;
import ru.urvanov.virtualpets.shared.domain.RefreshChatResult;
import ru.urvanov.virtualpets.shared.domain.SendChatMessageArg;
import ru.urvanov.virtualpets.shared.domain.SendChatMessageResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.ChatService;

/**
 * @author fedya
 *
 */
@Service("chatRemoting")
public class ChatRemoting implements ChatService {

    @Autowired
    private ru.urvanov.virtualpets.server.service.ChatService chatService;
    
    @Autowired
    private ru.urvanov.virtualpets.server.service.UserService userService;
    /**
     * 
     */
    public ChatRemoting() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.shared.service.ChatService#getMessages(ru.urvanov.virtualpets.shared.domain.RefreshChatArg)
     */
    @Override
    public RefreshChatResult getMessages(RefreshChatArg arg)
            throws DaoException, ServiceException {
        
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication  authentication = (Authentication) securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer userId = user.getId();
        
        user = userService.findById(userId);
        user.setActiveDate(new Date());
        userService.save(user);
        
        
        Integer id = arg.getLastChatMessageId();
        List<Chat> messages;
        if (id == null) {
            messages = chatService.findLast(20, userId);
        } else {
            messages = chatService.findFromId(id, userId);
        }
        
        RefreshChatResult result = new RefreshChatResult();
        result.setSuccess(true);
        
        ChatMessage[] chatMessages = new ChatMessage[messages.size()];
        int n = 0;
        for(Chat c: messages) {
            chatMessages[n] = new ChatMessage();
            User addressee = c.getAddressee();
            if (addressee != null) {
                chatMessages[n].setAddresseeId(addressee.getId());
                chatMessages[n].setAddresseeName(addressee.getName());
            }
            User sender = c.getSender();
            if (sender != null) {
                chatMessages[n].setSenderId(sender.getId());
                chatMessages[n].setSenderName(sender.getName());
            }
            chatMessages[n].setMessage(c.getMessage());
            chatMessages[n].setSendTime(c.getSendTime());
            chatMessages[n].setId(c.getId());
            n++;
        }
        
        if (chatMessages.length > 0) {
            result.setLastChatMessageId(chatMessages[chatMessages.length-1].getId());
        } else {
            result.setLastChatMessageId(arg.getLastChatMessageId());
        }
        result.setChatMessages(chatMessages);
        return result;
    }

    /* (non-Javadoc)
     * @see ru.urvanov.virtualpets.shared.service.ChatService#sendMessage(ru.urvanov.virtualpets.shared.domain.SendChatMessageArg)
     */
    @Override
    public SendChatMessageResult sendMessage(SendChatMessageArg arg)
            throws DaoException, ServiceException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User)authentication.getPrincipal();
        
        Chat chat = new Chat();
        if (arg.getAddresseeId() != null) {
            chat.setAddressee(userService.findById(arg.getAddresseeId()));
        }
        chat.setMessage(arg.getMessage());
        chat.setSender(userService.findById(user.getId()));
        chat.setSendTime(new Date());
        chatService.save(chat);
        
        SendChatMessageResult result = new SendChatMessageResult();
        result.setSuccess(true);
        return result;
    }

    /**
     * @return the chatService
     */
    public ru.urvanov.virtualpets.server.service.ChatService getChatService() {
        return chatService;
    }

    /**
     * @param chatService the chatService to set
     */
    public void setChatService(
            ru.urvanov.virtualpets.server.service.ChatService chatService) {
        this.chatService = chatService;
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

}
