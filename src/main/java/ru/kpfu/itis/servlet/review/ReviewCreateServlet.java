package ru.kpfu.itis.servlet.review;

import ru.kpfu.itis.dao.ReviewDao;
import ru.kpfu.itis.entity.Review;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review/create")
public class ReviewCreateServlet extends HttpServlet {
    private ReviewDao reviewDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        reviewDao = (ReviewDao) config.getServletContext().getAttribute("reviewDao");
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/review/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String rating = req.getParameter("rating");
        if(text == null || rating == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No text or rating has been provided.");
        }
        reviewDao.create(Review.builder()
                .userId(userService.getUser(req, resp).getId())
                .text(text)
                .rating(Integer.parseInt(rating))
                .isPublish(true)
                .build());
        resp.sendRedirect(req.getContextPath() + "/review/list");
    }
}
