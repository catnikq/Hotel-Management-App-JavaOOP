package io.catnikq.hotel_app.model;

import java.util.Date;
import java.util.List;

public class Booking {

    private int bookingID;
    private Customer customer;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private List<Service> services;
    private double totalPrice;
    
    // Constructor
    public Booking(int bookingID, Customer customer, Room room, Date checkInDate, Date checkOutDate, List<Service> services, double totalPrice) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.services = services;
        this.totalPrice = totalPrice;
    }
    
    // Default constructor
    public Booking(){
        
    }
    
    // Getters and Setters
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
