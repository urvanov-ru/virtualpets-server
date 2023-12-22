/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.Room;

/**
 * @author fedya
 *
 */
public interface RoomService {
    public Room findByPet(Pet pet);
    public Room findByPetId(Integer petId);
    public void save(Room room);
    public Room findOrCreateByPet(Pet pet);
}
