/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.Room;
import ru.urvanov.virtualpets.server.test.annotation.DataSets;

/**
 * @author fedya
 *
 */
public class RoomServiceImplTest extends AbstractServiceImplTest {
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private PetService petService;

    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RoomServiceImplTest.xls")
    @Test
    public void testFind1() {
        Room room = roomService.findByPetId(1);
        assertNotNull(room);
        assertNotNull(room.getPetId());
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RoomServiceImplTest.xls")
    @Test
    public void testFind2() {
        Room room = roomService.findByPetId(-1);
        assertNull(room);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RoomServiceImplTest.xls")
    @Test
    public void testSaveNew() {
        Room room = new Room();
        Pet pet = petService.findById(2);
        room.setPetId(pet.getId());
        room.setBoxNewbie1(true);
        room.setBoxNewbie2(true);
        room.setBoxNewbie3(true);
        roomService.save(room);
    }
    
    @DataSets(setUpDataSet = "/ru/urvanov/virtualpets/server/service/RoomServiceImplTest.xls")
    @Test
    public void testSaveExist() {
        Room room = roomService.findByPetId(1);
        room.setBoxNewbie1(false);
        roomService.save(room);
        room = roomService.findByPetId(1);
        assertEquals(room.getBoxNewbie1(), false);
    }
}
