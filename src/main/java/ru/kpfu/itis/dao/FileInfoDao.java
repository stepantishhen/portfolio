package ru.kpfu.itis.dao;

import ru.kpfu.itis.entity.FileInfo;
import ru.kpfu.itis.util.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileInfoDao {
    private ConnectionProvider connectionProvider;

    public FileInfoDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    private FileInfo mapToFileInfo(ResultSet rs) throws SQLException {
        return FileInfo.builder()
                .id(rs.getLong("id"))
                .originalFileName(rs.getString("original_file_name"))
                .storageFileName(rs.getString("storage_file_name"))
                .size(rs.getLong("size"))
                .type(rs.getString("type"))
                .description(rs.getString("description"))
                .build();
    }

    public void save(FileInfo entity) {
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement("INSERT INTO file (storage_file_name, original_file_name, type, size, description) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, entity.getStorageFileName());
            statement.setString(2, entity.getOriginalFileName());
            statement.setString(3, entity.getType());
            statement.setLong(4, entity.getSize());
            statement.setString(5, entity.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
        }
    }

    public FileInfo findById(Long id) {
        String SQL_SELECT_BY_ID = "SELECT * FROM file WHERE id = ?";
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapToFileInfo(resultSet);
            }
        } catch (SQLException e) {
            // Handle exception
        }
        return null;
    }

    public List<FileInfo> findAll() {
        String SQL_SELECT = "SELECT * FROM file";
        List<FileInfo> files = new ArrayList<>();
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                files.add(mapToFileInfo(resultSet));
            }
        } catch (SQLException e) {
            // Handle exception
        }
        return files;
    }

    public Object getCount() {
        String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM file";
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_SELECT_COUNT);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            // Handle exception
        }
        return null;
    }

    public void delete(int i) {
        String SQL_DELETE = "DELETE FROM file WHERE id = ?";
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_DELETE);
            statement.setInt(1, i);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            System.out.println("Error in FileInfoDao.delete(int i)");
        }
    }

    public FileInfo getDetail(int i) {
        String SQL_SELECT_BY_ID = "SELECT * FROM file WHERE id = ?";
        try {
            PreparedStatement statement = this.connectionProvider.getCon().prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, i);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapToFileInfo(resultSet);
            }
        } catch (SQLException e) {
            // Handle exception
        }
        return null;
    }
}
