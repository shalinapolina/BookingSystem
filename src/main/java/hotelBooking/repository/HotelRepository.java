package hotelBooking.repository;

import hotelBooking.model.Hotel;
import java.util.List;
import java.sql.SQLException;

public interface HotelRepository {
    List<Hotel> getAllHotels() throws SQLException;
    Hotel findById(int id) throws SQLException;
    void addHotel(Hotel h) throws SQLException;
    void deleteHotel(int id) throws SQLException;
}
