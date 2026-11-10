package hotelBooking;
import hotelBooking.model.*;
import hotelBooking.repository.HotelRepository;
import hotelBooking.repository.JdbcHotelRepository;
import hotelBooking.repository.JdbcRoomRepository;
import hotelBooking.repository.RoomRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:sqlite:hotel.db";
    public static void main(String[] args) throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(URL)) {
            HotelRepository hotels = new JdbcHotelRepository(DriverManager.getConnection(URL));
            RoomRepository rooms = new JdbcRoomRepository(DriverManager.getConnection(URL));
            System.out.println(hotels.getAllHotels());
            System.out.println(rooms.findByHotelId(1));
        }
    }
}
