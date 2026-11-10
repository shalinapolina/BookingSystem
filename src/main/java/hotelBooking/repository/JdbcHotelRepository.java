package hotelBooking.repository;

import hotelBooking.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHotelRepository implements HotelRepository{
    private final Connection connection;
    public JdbcHotelRepository(Connection connection)
    {
        this.connection = connection;
    }
    public List<Hotel> getAllHotels() throws SQLException
    {
        List<Hotel> hotels = new ArrayList<Hotel>();
        String sql = "SELECT * FROM hotels";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery())
        {
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Hotel h = new Hotel(id, title, description);
                hotels.add(h);
            }
        }
        return hotels;
    }
    public Hotel findById(int id) throws SQLException
    {
        String sql = "SELECT title, description FROM hotels WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery())
            {
                if (resultSet.next())
                {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    return new Hotel(id, title, description);
                }
            }
        }
        return null;
    }
    public void addHotel(Hotel h) throws SQLException
    {
        String title = h.getTitle();
        String description = h.getDescription();
        String sql = "INSERT INTO hotels (title, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, title);
            statement.setString(2, description);
            statement.executeUpdate();
        }
    }
    public void deleteHotel(int i) throws SQLException
    {
        String sql = "DELETE FROM hotels WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, i);
            statement.executeUpdate();
        }
    }
}
