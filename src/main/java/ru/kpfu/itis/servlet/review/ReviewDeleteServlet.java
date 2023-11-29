package ru.kpfu.itis.servlet.review;

import ru.kpfu.itis.dao.ReviewDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review/delete")
public class ReviewDeleteServlet extends HttpServlet {
    private ReviewDao reviewDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        reviewDao = (ReviewDao) config.getServletContext().getAttribute("reviewDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No id has been provided.");
        }
        reviewDao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/review/list");
    }
}