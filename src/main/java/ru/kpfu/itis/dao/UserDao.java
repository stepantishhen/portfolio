package ru.kpfu.itis.dao;

import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.util.ConnectionProvider;
import ru.kpfu.itis.util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private ConnectionProvider connectionProvider;

    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public User getUserByUsernameAndPassword(String username, String password) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement("SELECT * FROM users WHERE username = ?");
            st.setString(1, username);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                String hashedPasswordFromDB = result.getString("password");
                boolean passwordMatch = BCrypt.checkpw(password, hashedPasswordFromDB);

                if (passwordMatch) {
                    return User.builder()
                            .id(result.getInt("id"))
                            .username(result.getString("username"))
                            .password(result.getString("password"))
                            .role(result.getString("role"))
                            .build();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Can't get user from db.", e);
        }
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void registerUser(User user) throws DbException {
        try {
            if (isUserExists(user.getUsername())) {
                throw new DbException("User with the provided email already exists.");
            }

            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "INSERT INTO users (username, password, role) VALUES (?, ?, ?)"
            );
            System.out.println("user.getUsername(): " + user.getUsername());
            System.out.println("user.getPassword(): " + user.getPassword());
            st.setString(1, user.getUsername());
            st.setString(2, hashPassword(user.getPassword()));
            st.setString(3, user.getRole());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected != 1) {
                throw new DbException("Error registering the user. Rows affected: " + rowsAffected);
            }
        } catch (SQLException e) {
            throw new DbException("Error registering the user.", e);
        }
    }

    private boolean isUserExists(String username) throws SQLException {
        PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                "SELECT COUNT(id) AS cnt FROM users WHERE username = ?"
        );
        st.setString(1, username);
        ResultSet result = st.executeQuery();
        result.next();
        int count = result.getInt("cnt");
        return count > 0;
    }

    public void updateUser(User user) throws DbException, SQLException {
        PreparedStatement st = this.connectionProvider.getCon().prepareStatement("UPDATE users SET username=?, email=?, \"firstName\"=?, \"secondName\"=?, \"phoneNumber\"=? WHERE id=?");
        st.setString(1, user.getUsername());
        st.setString(2, user.getEmail());
        st.setString(3, user.getFirstName());
        st.setString(4, user.getSecondName());
        st.setString(5, user.getPhoneNumber());
        st.setLong(6, user.getId());
        int rowsAffected = st.executeUpdate();
        if (rowsAffected == 0) {
            throw new DbException("User update failed, no rows affected");
        }
    }
    public User getUserDetails(int userId) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement("SELECT * FROM users WHERE id = ?");
            st.setInt(1, userId);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"))
                        .email(resultSet.getString("email"))
                        .firstName(resultSet.getString("firstName"))
                        .secondName(resultSet.getString("secondName"))
                        .phoneNumber(resultSet.getString("phoneNumber"))
                        .role(resultSet.getString("role"))
                        .build();
            }
        } catch (SQLException e) {
            throw new DbException("Error fetching user details", e);
        }
        return null;
    }

    public List<User> getAll() throws SQLException {
        // get all users from db and return them
        PreparedStatement st = this.connectionProvider.getCon().prepareStatement("SELECT * FROM users");

        ResultSet result = st.executeQuery();
        List<User> users = new ArrayList<>();
        while (result.next()) {
            User user = User.builder()
                    .username(result.getString("username"))
                    .email(result.getString("email"))
                    .firstName(result.getString("firstName"))
                    .secondName(result.getString("secondName"))
                    .phoneNumber(result.getString("phoneNumber"))
                    .role(result.getString("role"))
                    .build();
            users.add(user);
        }
        return users;
    }
}
