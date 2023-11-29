package ru.kpfu.itis.servlet.file;

import ru.kpfu.itis.dao.FileInfoDao;
import ru.kpfu.itis.service.FileService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/file/create")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class FileCreateServlet extends HttpServlet {
    private FileInfoDao fileInfoDao;
    private FileService fileService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        fileInfoDao = (FileInfoDao) getServletContext().getAttribute("fileInfoDao");
        fileService = (FileService) getServletContext().getAttribute("fileService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/files/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String description = req.getParameter("description");
        Part part = req.getPart("file");
        fileService.saveFileToStorage(
                part.getInputStream(),
                part.getSubmittedFileName(),
                part.getContentType(),
                part.getSize(),
                description);
        resp.sendRedirect(req.getContextPath() + "/file/create");
    }
}
