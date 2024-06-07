package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Booking;
import java.util.List;

public interface BookingController {

    void addBooking(Booking booking);

    Booking getBookingById(int bookingId);

    void updateBooking(Booking booking);

    void deleteBooking(int bookingId);

    List<Booking> getAllBookings();
}
