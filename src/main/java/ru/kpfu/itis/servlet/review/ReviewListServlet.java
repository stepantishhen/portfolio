package ru.kpfu.itis.servlet.review;

import ru.kpfu.itis.dao.ReviewDao;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review/list")
public class ReviewListServlet extends HttpServlet {
    private ReviewDao reviewDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        reviewDao = (ReviewDao) getServletContext().getAttribute("reviewDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("reviews", reviewDao.getAll());
        req.getRequestDispatcher("/WEB-INF/view/review/list.jsp").forward(req, resp);
    }
}
