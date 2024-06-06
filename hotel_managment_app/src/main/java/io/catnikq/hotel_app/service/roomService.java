package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class roomService {
    public void addRoom(Room room) {
        room.setRoomNumber(inMemoryDatabase.getNextRoomId());
        inMemoryDatabase.rooms.put(room.getRoomNumber(), room);
    }

    public Room getRoomByNumber(int roomNumber) {
        return inMemoryDatabase.rooms.get(roomNumber);
    }

    public void updateRoom(Room room) {
        if (inMemoryDatabase.rooms.containsKey(room.getRoomNumber())) {
            inMemoryDatabase.rooms.put(room.getRoomNumber(), room);
        }
    }

    public void deleteRoom(int roomNumber) {
        inMemoryDatabase.rooms.remove(roomNumber);
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(inMemoryDatabase.rooms.values());
    }

    public boolean bookRoom(int roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && "Available".equals(room.getStatus())) {
            room.setStatus("Booked");
            return true;
        }
        return false;
    }

    public void releaseRoom(int roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && "Booked".equals(room.getStatus())) {
            room.setStatus("Available");
        }
    }
}
