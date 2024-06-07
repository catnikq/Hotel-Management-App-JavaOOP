package inMemoryDAO;

import io.catnikq.hotel_app.model.Booking;
import java.util.List;

public interface BookingDAO {

    void save(Booking booking);

    Booking getById(int bookingId);

    void update(Booking booking);

    void delete(int bookingId);

    List<Booking> getAll();
}
