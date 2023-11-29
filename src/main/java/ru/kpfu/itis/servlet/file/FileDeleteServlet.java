package ru.kpfu.itis.servlet.file;

import ru.kpfu.itis.dao.FileInfoDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file/delete")
public class FileDeleteServlet extends HttpServlet {
    private FileInfoDao fileInfoDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        fileInfoDao = (FileInfoDao) getServletContext().getAttribute("fileInfoDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No id has been provided.");
        }
        fileInfoDao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/file/list");
    }
}