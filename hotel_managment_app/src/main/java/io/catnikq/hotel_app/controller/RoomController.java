package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Room;
import java.util.List;

public interface RoomController {

    void addRoom(Room room);

    Room getRoomByNumber(int roomNumber);

    void updateRoom(Room room);

    void deleteRoom(int roomNumber);

    List<Room> getAllRooms();
}
