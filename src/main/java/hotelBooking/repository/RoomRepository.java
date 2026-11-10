package hotelBooking.repository;

import hotelBooking.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomRepository {
    public List<Room> findByHotelId(int id) throws SQLException;
    public void add(Room room) throws SQLException;
    public void deleteRoom(int id) throws SQLException;
    public void updatePrice(int id, int newPrice) throws SQLException;
    public void setEnabled(int id, boolean enabled) throws SQLException;
}
