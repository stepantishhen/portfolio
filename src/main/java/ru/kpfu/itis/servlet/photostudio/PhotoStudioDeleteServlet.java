package ru.kpfu.itis.servlet.photostudio;

import ru.kpfu.itis.dao.PhotoStudioDao;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/photostudio/delete")
public class PhotoStudioDeleteServlet extends HttpServlet {
    private PhotoStudioDao photoStudioDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        photoStudioDao = (PhotoStudioDao) config.getServletContext().getAttribute("photoStudioDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No id has been provided.");
        }
        photoStudioDao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/photostudio/list");
    }
}