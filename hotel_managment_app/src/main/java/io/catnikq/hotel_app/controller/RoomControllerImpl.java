package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.service.roomService;
import java.util.List;

public class RoomControllerImpl implements RoomController {

    private roomService roomService;

    public RoomControllerImpl(roomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void addRoom(Room room) {
        roomService.addRoom(room);
    }

    @Override
    public Room getRoomByNumber(int roomNumber) {
        return roomService.getRoomByNumber(roomNumber);
    }

    @Override
    public void updateRoom(Room room) {
        roomService.updateRoom(room);
    }

    @Override
    public void deleteRoom(int roomNumber) {
        roomService.deleteRoom(roomNumber);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

}
