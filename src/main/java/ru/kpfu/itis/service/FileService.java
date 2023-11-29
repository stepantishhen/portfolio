package ru.kpfu.itis.service;

import ru.kpfu.itis.dao.FileInfoDao;
import ru.kpfu.itis.entity.FileInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileService {
    private String pathToUpload = "/home/stepantishhen/IdeaProjects/servlet-bookcatalogue/src/main/webapp/WEB-INF/upload/";
    private FileInfoDao fileInfoDao;

    public FileService(FileInfoDao fileInfoDao) {
        this.fileInfoDao = fileInfoDao;
    }

    public void saveFileToStorage(InputStream file, String originalFileName, String contentType, Long size, String description) throws IOException {
        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(UUID.randomUUID().toString())
                .size(size)
                .type(contentType)
                .description(description)
                .build();
        try {
            String[] typeParts = fileInfo.getType().split("/");
            String fileExtension = (typeParts.length > 1) ? typeParts[1] : ""; // Check if typeParts has at least 2 elements

            Files.copy(file, Paths.get(pathToUpload + fileInfo.getStorageFileName() + "." + fileExtension));
            fileInfoDao.save(fileInfo);
        } catch (IOException e) { // Catch NullPointerException
            throw new IllegalArgumentException(e);
        }
    }


    public void writeFileFromStorage(Long fileId, OutputStream outputStream) {
        // нашли файл в базе
        FileInfo fileInfo = fileInfoDao.findById(fileId);
        // нашли файл на диске
        File file = new File(pathToUpload + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]);
        try {
            // записали его в ответ
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public FileInfo getFileInfo(long l) {
        return fileInfoDao.findById(l);
    }
}