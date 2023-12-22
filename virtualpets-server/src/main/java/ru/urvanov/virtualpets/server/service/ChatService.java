/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import java.util.List;

import ru.urvanov.virtualpets.server.domain.Chat;

/**
 * @author fedya
 *
 */
public interface ChatService {
    public Chat findById(Integer id);
    public List<Chat> findLast(Integer count, Integer userId);
    public List<Chat> findFromId(Integer fromId, Integer userId);
    public void save(Chat chat);
}
