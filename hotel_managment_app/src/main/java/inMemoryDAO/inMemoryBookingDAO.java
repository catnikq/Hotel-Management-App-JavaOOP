package inMemoryDAO;

import io.catnikq.hotel_app.mockData.inMemoryDatabase;
import static io.catnikq.hotel_app.mockData.inMemoryDatabase.bookings;
import io.catnikq.hotel_app.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class inMemoryBookingDAO implements BookingDAO {

    @Override
    public void save(Booking booking) {
        int bookingId = inMemoryDatabase.getNextBookingId();
        booking.setBookingID(bookingId);
        inMemoryDatabase.bookings.put(bookingId, booking);
    }

    @Override
    public Booking getById(int bookingId) {
        return inMemoryDatabase.bookings.get(bookingId);
    }

    @Override
    public void update(Booking booking) {
        if (inMemoryDatabase.bookings.containsKey(booking.getBookingID())) {
            inMemoryDatabase.bookings.put(booking.getBookingID(), booking);
        }
    }

    @Override
    public void delete(int bookingId) {
        inMemoryDatabase.bookings.remove(bookingId);
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(inMemoryDatabase.bookings.values());
    }

    @Override
    public Booking getByRoomNumber(int roomNumber) {
        return bookings.values().stream()
            .filter(booking -> booking.getRoom().getRoomNumber() == roomNumber)
            .findFirst()
            .orElse(null);
    }

}
