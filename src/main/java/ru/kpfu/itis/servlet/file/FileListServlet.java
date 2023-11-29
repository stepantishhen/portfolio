package ru.kpfu.itis.servlet.file;

import ru.kpfu.itis.dao.FileInfoDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file/list")
public class FileListServlet extends HttpServlet {
    private FileInfoDao fileInfoDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        fileInfoDao = (FileInfoDao) config.getServletContext().getAttribute("fileInfoDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("files", fileInfoDao.findAll());
        req.setAttribute("filesCount", fileInfoDao.getCount());
        req.getRequestDispatcher("/WEB-INF/view/files/list.jsp").forward(req, resp);
    }
}
