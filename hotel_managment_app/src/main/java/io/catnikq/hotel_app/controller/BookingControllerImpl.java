package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.service.bookingService;
import java.util.List;

public class BookingControllerImpl implements BookingController {

    private bookingService bookingService;

    public BookingControllerImpl(bookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void addBooking(Booking booking) {
        bookingService.addBooking(booking);
    }

    @Override
    public Booking getBookingById(int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingService.updateBooking(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @Override
    public Booking getBookingByRoomNumber(int roomNumber) {
        return bookingService.getBookingByRoomNumber(roomNumber);
    }

}
