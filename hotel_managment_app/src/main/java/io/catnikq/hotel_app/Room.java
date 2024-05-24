package io.catnikq.hotel_app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomNumber;
    private String floor;
    private String roomType;
    private Float roomPrice;
    private Boolean roomStatus;
    private List<String> amenities;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    //Getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public Float getRoomPrice() {
        return roomPrice;
    }

    public Boolean getRoomStatus() {
        return roomStatus;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    
    //Setters
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomPrice(Float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
}