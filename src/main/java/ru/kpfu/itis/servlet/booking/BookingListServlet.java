package ru.kpfu.itis.servlet.booking;

import ru.kpfu.itis.dao.BookingDao;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booking/list")
public class BookingListServlet extends HttpServlet {
    private BookingDao bookingDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bookingDao = (BookingDao) getServletContext().getAttribute("bookingDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookings", bookingDao.getAll());
        req.getRequestDispatcher("/WEB-INF/view/bookings/list.jsp").forward(req, resp);
    }
}
