package io.catnikq.hotel_app.model;

import java.util.Date;

public class Payment {

    private int paymentID;
    private int bookingID;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;

    // Constructor
    public Payment(int paymentId, double amount, Date paymentDate, String paymentMethod) {
        this.paymentID = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    // Default constructor
    public Payment() {

    }

    // Getters and Setters
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // toString method
    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID
                + ", bookingID=" + bookingID
                + ", amount=" + amount
                + ", paymentDate=" + paymentDate
                + ", paymentMethod=" + paymentMethod + '}';
    }


}
