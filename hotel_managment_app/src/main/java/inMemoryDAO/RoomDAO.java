package inMemoryDAO;

import io.catnikq.hotel_app.model.Room;
import java.util.List;


public interface RoomDAO {
    void save(Room room);
    Room getByNumber(int roomNumber);
    void update(Room room);
    void delete(int roomNumber);
    List<Room> getAll();
}
