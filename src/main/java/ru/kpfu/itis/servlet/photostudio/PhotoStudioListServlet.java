package ru.kpfu.itis.servlet.photostudio;

import ru.kpfu.itis.dao.PhotoStudioDao;
import ru.kpfu.itis.entity.PhotoStudio;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/photostudio/list")
public class PhotoStudioListServlet extends HttpServlet {
    private PhotoStudioDao photoStudioDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        photoStudioDao = (PhotoStudioDao) getServletContext().getAttribute("photoStudioDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("photostudios", photoStudioDao.getAll());
        req.getRequestDispatcher("/WEB-INF/view/photostudio/list.jsp").forward(req, resp);
    }
}
