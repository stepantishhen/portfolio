package ru.kpfu.itis.servlet;

import ru.kpfu.itis.dao.FileInfoDao;
import ru.kpfu.itis.dao.ReviewDao;
import ru.kpfu.itis.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private FileInfoDao fileInfoDao;
    private ReviewDao reviewDao;
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        fileInfoDao = (FileInfoDao) getServletContext().getAttribute("fileInfoDao");
        reviewDao = (ReviewDao) getServletContext().getAttribute("reviewDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("files", fileInfoDao.findAll());
        req.setAttribute("reviews", reviewDao.getFive());
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
