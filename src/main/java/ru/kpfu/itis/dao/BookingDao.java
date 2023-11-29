package ru.kpfu.itis.dao;

import ru.kpfu.itis.entity.Booking;
import ru.kpfu.itis.entity.PhotoStudio;
import ru.kpfu.itis.util.ConnectionProvider;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private ConnectionProvider connectionProvider;
    private String SQL_DELETE_BY_ID = "DELETE FROM booking WHERE id = ?";
    private String SQL_GET_ALL = "SELECT * FROM booking";
    // create booking
    private String SQL_CREATE = "INSERT INTO booking (userid, photostudioid, date) VALUES (?, ?, ?)";

    public BookingDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public void create(Booking booking) {
        System.out.println("BookingDao.create(Booking booking)");
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_CREATE);
            statement.setInt(1, booking.getUserId());
            statement.setInt(2, booking.getPhotoStudioId());
            statement.setDate(3, Date.valueOf(booking.getDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in BookingDao.create(Booking booking)");
        }
    }
    public void delete(int i) {
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_DELETE_BY_ID);
            statement.setInt(1, i);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in BookingDao.delete(int i)");
        }
    }

    // get all bookings from db
    public List<Booking> getAll() {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_GET_ALL);
            ResultSet result = st.executeQuery();
            List<Booking> bookings = new ArrayList<>();
            while(result.next()){
                bookings.add(Booking.builder()
                        .id(result.getInt("id"))
                        .userId(result.getInt("userid"))
                        .photoStudioId(result.getInt("photostudioid"))
                        .date(String.valueOf(result.getDate("date").toLocalDate()))
                        .build());
            }
            return bookings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object get(long id) {
        return null;
    }
}
