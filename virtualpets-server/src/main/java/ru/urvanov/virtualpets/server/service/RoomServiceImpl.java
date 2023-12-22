/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.urvanov.virtualpets.server.dao.RoomDao;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.Room;

/**
 * @author fedya
 *
 */
@Service(value="roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;
    
    @Override
    public Room findByPet(Pet pet) {
        return roomDao.findByPetId(pet.getId());
    }

    @Override
    public Room findByPetId(Integer petId) {
        return roomDao.findByPetId(petId);
    }

    @Override
    public void save(Room room) {
        roomDao.save(room);
    }

    /**
     * @return the roomDao
     */
    public RoomDao getRoomDao() {
        return roomDao;
    }

    /**
     * @param roomDao the roomDao to set
     */
    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    @Transactional
    public Room findOrCreateByPet(Pet pet) {
        Room room = roomDao.findByPetId(pet.getId());
        if (room == null) {
            room = new Room();
            room.setPetId(pet.getId());
            room.setBoxNewbie1(false);
            room.setBoxNewbie2(false);
            room.setBoxNewbie3(false);
            save(room);
        }
        return room;
        
    }

}
