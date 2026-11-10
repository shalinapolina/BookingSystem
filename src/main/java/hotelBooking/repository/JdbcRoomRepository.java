package hotelBooking.repository;

import hotelBooking.model.DeluxeRoom;
import hotelBooking.model.Room;
import hotelBooking.model.StandardRoom;
import hotelBooking.model.Suite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRoomRepository implements RoomRepository{
    private final Connection connection;
    public JdbcRoomRepository(Connection connection)
    {
        this.connection = connection;
    }
    public List<Room> findByHotelId(int i) throws SQLException
    {
        List<Room> rooms = new ArrayList<Room>();
        String sql = "SELECT * FROM rooms WHERE hotel_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, i);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int hotelId = resultSet.getInt("hotel_id");
                    int capacity = resultSet.getInt("capacity");
                    int pricePerNight = resultSet.getInt("price_per_night");
                    String description = resultSet.getString("description");
                    boolean enabled = resultSet.getInt("is_enabled") == 1;
                    String type = resultSet.getString("type");
                    Room room;
                    switch (type) {
                        case "STANDARD": {
                            room = new StandardRoom(id, hotelId, capacity, pricePerNight, description, enabled);
                            break;
                        }
                        case "DELUXE": {
                            room = new DeluxeRoom(id, hotelId, capacity, pricePerNight, description, enabled);
                            break;
                        }
                        case "SUITE": {
                            room = new Suite(id, hotelId, capacity, pricePerNight, description, enabled);
                            break;
                        }
                        default:
                            throw new IllegalArgumentException("Неизвестный тип номера: " + type);
                    }
                    rooms.add(room);
                }
            }
            return rooms;
        }
    }
    public void add(Room room) throws SQLException
    {
        int hotelId = room.getHotelId();
        int capacity = room.getCapacity();
        int pricePerNight = room.getPricePerNight();
        String description = room.getDescription();
        boolean enabled = room.getIsEnabled();
        String type = room.getTypeName();
        String sql = "INSERT INTO rooms (hotel_id, capacity, price_per_night, description, is_enabled, type) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, hotelId);
            statement.setInt(2, capacity);
            statement.setInt(3, pricePerNight);
            statement.setString(4, description);
            statement.setInt(5, enabled ? 1 : 0);
            statement.setString(6, type);
            statement.executeUpdate();
        }
    }
    public void deleteRoom(int id) throws SQLException
    {
        String sql = "DELETE FROM rooms WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public void updatePrice(int id, int newPrice) throws SQLException
    {
        String sql = "UPDATE rooms SET price_per_night = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, newPrice);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
    public void setEnabled(int id, boolean enabled) throws SQLException
    {
        String sql = "UPDATE rooms SET is_enabled = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, enabled ? 1 : 0);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
}
