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

@WebServlet("/photostudio/create")
public class PhotoStudioCreateServlet extends HttpServlet {
    private PhotoStudioDao photoStudioDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        photoStudioDao = (PhotoStudioDao) config.getServletContext().getAttribute("photoStudioDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/photostudio/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // title, description, address, phonenumber, email
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String address = req.getParameter("address");
        String phonenumber = req.getParameter("phonenumber");
        String email = req.getParameter("email");
        if(title == null || description == null || address == null || phonenumber == null || email == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No title or description or address or phonenumber or email has been provided.");
        }

        photoStudioDao.create(PhotoStudio.builder()
                .title(title)
                .description(description)
                .address(address)
                .phoneNumber(phonenumber)
                .email(email)
                .build());
        resp.sendRedirect(req.getContextPath() +"/photostudio/list");
    }
}
