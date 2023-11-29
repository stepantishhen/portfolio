package ru.kpfu.itis.dao;

import ru.kpfu.itis.entity.PhotoStudio;
import ru.kpfu.itis.entity.Review;
import ru.kpfu.itis.util.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotoStudioDao {
    private ConnectionProvider connectionProvider;
    private static final String SQL_CREATE_PHOTO_STUDIO = "INSERT INTO photo_studio(title, description, address, phonenumber, email) VALUES (?, ?, ?, ?, ?)";
    // get by id
    private static final String SQL_GET_PHOTO_STUDIO_BY_ID = "SELECT * FROM photo_studio WHERE id = ?";
    private static final String SQL_GET_ALL_PHOTO_STUDIOS = "SELECT * FROM photo_studio";
    private static final String SQL_DELETE_PHOTO_STUDIO_BY_ID = "DELETE FROM photo_studio WHERE id = ?";
    public PhotoStudioDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    // create photo studio in database
    public void create(PhotoStudio photoStudio) {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_CREATE_PHOTO_STUDIO);
            st.setString(1, photoStudio.getTitle());
            st.setString(2, photoStudio.getDescription());
            st.setString(3, photoStudio.getAddress());
            st.setString(4, photoStudio.getPhoneNumber());
            st.setString(5, photoStudio.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int i) {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_DELETE_PHOTO_STUDIO_BY_ID);
            st.setInt(1, i);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object get(int i) {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_GET_PHOTO_STUDIO_BY_ID);
            st.setInt(1, i);
            ResultSet result = st.executeQuery();
            if(result.next()){
                return PhotoStudio.builder()
                        .id(result.getInt("id"))
                        .title(result.getString("title"))
                        .description(result.getString("description"))
                        .address(result.getString("address"))
                        .phoneNumber(result.getString("phonenumber"))
                        .email(result.getString("email"))
                        .build();
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PhotoStudio> getAll() {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_GET_ALL_PHOTO_STUDIOS);
            ResultSet result = st.executeQuery();
            List<PhotoStudio> photoStudios = new ArrayList<>();
            while(result.next()){
                photoStudios.add(PhotoStudio.builder()
                        .id(result.getInt("id"))
                        .title(result.getString("title"))
                        .description(result.getString("description"))
                        .address(result.getString("address"))
                        .phoneNumber(result.getString("phonenumber"))
                        .email(result.getString("email"))
                        .build());
            }
            return photoStudios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
