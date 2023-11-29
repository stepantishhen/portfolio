package ru.kpfu.itis;

import ru.kpfu.itis.dao.*;
import ru.kpfu.itis.service.FileService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.ConnectionProvider;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("fileInfoDao", new FileInfoDao(connectionProvider));
            sce.getServletContext().setAttribute("userDao", new UserDao(connectionProvider));
            sce.getServletContext().setAttribute("reviewDao", new ReviewDao(connectionProvider));
            sce.getServletContext().setAttribute("photoStudioDao", new PhotoStudioDao(connectionProvider));
            sce.getServletContext().setAttribute("bookingDao", new BookingDao(connectionProvider));
            sce.getServletContext().setAttribute("userService", new UserService());
            sce.getServletContext().setAttribute("fileService", new FileService(new FileInfoDao(connectionProvider)));
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }
}
