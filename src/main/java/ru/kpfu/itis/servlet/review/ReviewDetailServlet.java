package ru.kpfu.itis.servlet.review;

import ru.kpfu.itis.dao.ReviewDao;
import ru.kpfu.itis.entity.Review;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review/detail")
public class ReviewDetailServlet extends HttpServlet {
    private ReviewDao reviewDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        reviewDao = (ReviewDao) getServletContext().getAttribute("reviewDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No id has been provided.");
        }
        Review review = reviewDao.getDetail(Integer.parseInt(id));
        if(review == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            req.getRequestDispatcher("/WEB-INF/view/errors/notfound.jsp").forward(req, resp);
        }
        req.setAttribute("review", review);
        req.getRequestDispatcher("/WEB-INF/view/review/detail.jsp").forward(req, resp);
    }
}
