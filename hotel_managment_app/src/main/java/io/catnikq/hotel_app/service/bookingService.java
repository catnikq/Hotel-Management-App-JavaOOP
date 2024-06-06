package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Customer;
import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class bookingService {

    private roomService roomService = new roomService();
    private customerService customerService = new customerService();

    public void addBooking(Booking booking) {
        int bookingId = inMemoryDatabase.getNextBookingId();
        booking.setBookingID(bookingId);

        Customer customer = booking.getCustomer();
        Room room = booking.getRoom();

        if (customer != null && room != null) {
            if (roomService.bookRoom(room.getRoomNumber())) {
                inMemoryDatabase.bookings.put(bookingId, booking);
            }
        }
    }

    public Booking getBookingById(int bookingId) {
        return inMemoryDatabase.bookings.get(bookingId);
    }

    public void updateBooking(Booking booking) {
        if (inMemoryDatabase.bookings.containsKey(booking.getBookingID())) {
            inMemoryDatabase.bookings.put(booking.getBookingID(), booking);
        }
    }

    public void deleteBooking(int bookingId) {
        Booking booking = inMemoryDatabase.bookings.remove(bookingId);
        if (booking != null) {
            roomService.releaseRoom(booking.getRoom().getRoomNumber());
        }
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(inMemoryDatabase.bookings.values());
    }
}
