package io.catnikq.hotel_app.service;

import inMemoryDAO.*;
import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Customer;
import io.catnikq.hotel_app.model.Room;

import java.util.List;

public class bookingService {

    private final BookingDAO bookingDAO;
    private final RoomDAO roomDAO;
    private final CustomerDAO customerDAO;

    public bookingService(BookingDAO bookingDAO, RoomDAO roomDAO, CustomerDAO customerDAO) {
        this.bookingDAO = bookingDAO;
        this.roomDAO = roomDAO;
        this.customerDAO = customerDAO;
    }

    public void addBooking(Booking booking) {
        Customer customer = booking.getCustomer();
        Room room = booking.getRoom();

        if (customer != null && room != null && roomDAO.getByNumber(room.getRoomNumber()) != null) {
            if ("Available".equals(room.getStatus())) {
                room.setStatus("Booked");
                roomDAO.update(room);
                bookingDAO.save(booking);
            }
        }
    }

    public Booking getBookingById(int bookingId) {
        return bookingDAO.getById(bookingId);
    }

    public Booking getBookingByRoomNumber(int roomNumber) {
        return bookingDAO.getByRoomNumber(roomNumber);
    }
    
    public void updateBooking(Booking booking) {
        bookingDAO.update(booking);
    }

    public void deleteBooking(int bookingId) {
        Booking booking = bookingDAO.getById(bookingId);
        if (booking != null) {
            Room room = booking.getRoom();
            if (room != null && "Booked".equals(room.getStatus())) {
                room.setStatus("Available");
                roomDAO.update(room);
            }
            bookingDAO.delete(bookingId);
        }
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }
}
