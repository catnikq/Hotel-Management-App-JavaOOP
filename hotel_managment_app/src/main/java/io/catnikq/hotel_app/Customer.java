package io.catnikq.hotel_app;

import java.util.List;

public class Customer extends Person {
    private int customerID;
    private List<Booking> bookingHistory;

    public Customer(int customerID, List<Booking> bookingHistory, String name, String address, String phoneNumber, Integer age, String gender) {
        super(name, address, phoneNumber, age, gender);
        this.customerID = customerID;
        this.bookingHistory = bookingHistory;
    }

    //Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(List<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
    
    
    
}
