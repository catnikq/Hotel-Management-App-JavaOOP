package io.catnikq.hotel_app.inMemoryDAO;

import io.catnikq.hotel_app.mockData.inMemoryDatabase;
import io.catnikq.hotel_app.model.Room;
import java.util.ArrayList;
import java.util.List;

public class inMemoryRoomDAO implements RoomDAO {

    @Override
    public void save(Room room) {
        room.setRoomNumber(inMemoryDatabase.getNextRoomId());
        inMemoryDatabase.rooms.put(room.getRoomNumber(), room);
    }

    @Override
    public Room getByNumber(int roomNumber) {
        return inMemoryDatabase.rooms.get(roomNumber);
    }

    @Override
    public void update(Room room) {
        if (inMemoryDatabase.rooms.containsKey(room.getRoomNumber())) {
            inMemoryDatabase.rooms.put(room.getRoomNumber(), room);
        }
    }

    @Override
    public void delete(int roomNumber) {
        inMemoryDatabase.rooms.remove(roomNumber);
    }

    @Override
    public List<Room> getAll() {
        return new ArrayList<>(inMemoryDatabase.rooms.values());
    }

}
