package ru.kpfu.itis.servlet.file;

import ru.kpfu.itis.dao.FileInfoDao;
import ru.kpfu.itis.entity.FileInfo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file/detail")
public class FileDetailServlet extends HttpServlet {
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
        FileInfo file = fileInfoDao.getDetail(Integer.parseInt(id));
        if(file == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            req.getRequestDispatcher("/WEB-INF/view/errors/notfound.jsp").forward(req, resp);
        }
        req.setAttribute("file", file);
        req.getRequestDispatcher("/WEB-INF/view/files/detail.jsp").forward(req, resp);
    }
}
