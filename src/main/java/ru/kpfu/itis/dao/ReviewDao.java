package ru.kpfu.itis.dao;

import ru.kpfu.itis.entity.FileInfo;
import ru.kpfu.itis.entity.Review;
import ru.kpfu.itis.util.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    private ConnectionProvider connectionProvider;
    // SQL queries
    private static final String SQL_CREATE_REVIEW = "INSERT INTO review (userid, text, rating, ispublish) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE_REVIEW = "DELETE FROM review WHERE id = ?";
    private static final String SQL_GET_REVIEW = "SELECT * FROM review WHERE id = ?";
    private static final String SQL_GET_ALL_REVIEW = "SELECT * FROM review";
    private static final String SQL_GET_FIVE_REVIEW = "SELECT * FROM review LIMIT 5";
    public ReviewDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public void create(Review review) {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_CREATE_REVIEW);
            st.setInt(1, review.getUserId());
            st.setString(2, review.getText());
            st.setInt(3, review.getRating());
            st.setBoolean(4, true);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int i) {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_DELETE_REVIEW);
            st.setInt(1, i);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Review getDetail(int i) {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_GET_REVIEW);
            st.setInt(1, i);
            ResultSet result = st.executeQuery();
            if(result.next()){
                return Review.builder()
                        .id(result.getInt("id"))
                        .userId(result.getInt("userid"))
                        .text(result.getString("text"))
                        .rating(result.getInt("rating"))
                        .isPublish(result.getBoolean("ispublish"))
                        .build();
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // get all reviews
    public List<Review> getAll() {
        // get all reviews and add them to list and return
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_GET_ALL_REVIEW);
            ResultSet result = st.executeQuery();
            List<Review> reviews = new ArrayList<>();
            while(result.next()){
                reviews.add(Review.builder()
                        .id(result.getInt("id"))
                        .userId(result.getInt("userid"))
                        .text(result.getString("text"))
                        .rating(result.getInt("rating"))
                        .isPublish(result.getBoolean("ispublish"))
                        .build());
            }
            return reviews;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Review> getFive() {
        try {
            PreparedStatement st = connectionProvider.getCon().prepareStatement(SQL_GET_FIVE_REVIEW);
            ResultSet result = st.executeQuery();
            List<Review> reviews = new ArrayList<>();
            while(result.next()){
                reviews.add(Review.builder()
                        .id(result.getInt("id"))
                        .userId(result.getInt("userid"))
                        .text(result.getString("text"))
                        .rating(result.getInt("rating"))
                        .isPublish(result.getBoolean("ispublish"))
                        .build());
            }
            return reviews;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
