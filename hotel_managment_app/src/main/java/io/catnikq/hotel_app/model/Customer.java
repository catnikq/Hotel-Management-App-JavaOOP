package io.catnikq.hotel_app.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

    private int customerID;
    private List<Booking> bookingHistory;

    // Constructor
    public Customer(int id, int customerID, String name, String address, String phoneNumber, Integer age, String gender) {
        super(id, name, address, phoneNumber, age, gender);
        this.customerID = customerID;
        this.bookingHistory = new ArrayList<>();
    }

    // Default constructor
    public Customer() {
        this.bookingHistory = new ArrayList<>();
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID
                + ", bookingHistory=" + bookingHistory
                + ", id=" + getId()
                + ", name='" + getName() + '\'' 
                + ", address='" + getAddress() + '\''
                + ", phoneNumber='" + getPhoneNumber() + '\''
                + ", age=" + getAge()
                + ", gender='" + getGender() + '\'' + '}';
    }

}
