package ru.urvanov.virtualpets.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.ChatDao;
import ru.urvanov.virtualpets.server.domain.Chat;

@Service(value="chatService")
public class ChatServiceImpl implements ChatService {

    
    @Autowired
    private ChatDao chatDao;
    
    public ChatServiceImpl() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @return the chatDao
     */
    public ChatDao getChatDao() {
        return chatDao;
    }

    /**
     * @param chatDao the chatDao to set
     */
    public void setChatDao(ChatDao chatDao) {
        this.chatDao = chatDao;
    }


    @Override
    public Chat findById(Integer id) {
        return chatDao.findById(id);
    }


    @Override
    public List<Chat> findLast(Integer count, Integer userId) {
        return chatDao.findLast(count, userId);
    }


    @Override
    public void save(Chat chat) {
        chatDao.save(chat);
    }


    @Override
    public List<Chat> findFromId(Integer fromId, Integer userId) {
        return chatDao.findFromId(fromId, userId);
    }

}
