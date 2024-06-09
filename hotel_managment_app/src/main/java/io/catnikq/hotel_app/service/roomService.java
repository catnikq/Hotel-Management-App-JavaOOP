package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.inMemoryDAO.RoomDAO;
import io.catnikq.hotel_app.model.Room;

import java.util.List;

public class roomService {

    private RoomDAO roomDAO;

    public roomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public void addRoom(Room room) {
        roomDAO.save(room);
    }

    public Room getRoomByNumber(int roomNumber) {
        return roomDAO.getByNumber(roomNumber);
    }

    public void updateRoom(Room room) {
        roomDAO.update(room);
    }

    public void deleteRoom(int roomNumber) {
        roomDAO.delete(roomNumber);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAll();
    }

    public boolean bookRoom(int roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && "Available".equals(room.getStatus())) {
            room.setStatus("Booked");
            updateRoom(room);
            return true;
        }
        return false;
    }

    public void releaseRoom(int roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && "Booked".equals(room.getStatus())) {
            room.setStatus("Available");
            updateRoom(room);
        }
    }
}
