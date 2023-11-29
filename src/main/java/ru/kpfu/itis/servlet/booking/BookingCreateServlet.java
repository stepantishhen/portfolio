package ru.kpfu.itis.servlet.booking;

import ru.kpfu.itis.dao.BookingDao;
import ru.kpfu.itis.dao.PhotoStudioDao;
import ru.kpfu.itis.entity.Booking;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booking/create")
public class BookingCreateServlet extends HttpServlet {
    private BookingDao bookingDao;
    private PhotoStudioDao photoStudioDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bookingDao = (BookingDao) getServletContext().getAttribute("bookingDao");
        photoStudioDao = (PhotoStudioDao) getServletContext().getAttribute("photoStudioDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("photostudios", photoStudioDao.getAll());
        req.getRequestDispatcher("/WEB-INF/view/bookings/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get current user id
        String userId = String.valueOf(userService.getUser(req, resp).getId());
        String photostudioid = req.getParameter("photostudioId");
        String date = req.getParameter("date");
        System.out.println(userId);
        System.out.println(photostudioid);
        System.out.println(date);

        if(userId == null || photostudioid == null || date == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No userId or photostudioid or date has been provided.");
        }
        bookingDao.create(Booking.builder()
                .userId(Integer.parseInt(userId))
                .photoStudioId(Integer.parseInt(photostudioid))
                .date(date)
                .build());
        resp.sendRedirect(req.getContextPath() + "/booking/list");
    }
}
