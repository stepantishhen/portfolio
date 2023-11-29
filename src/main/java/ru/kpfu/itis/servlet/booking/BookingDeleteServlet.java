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

@WebServlet("/booking/delete")
public class BookingDeleteServlet extends HttpServlet {
    private BookingDao bookingDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bookingDao = (BookingDao) getServletContext().getAttribute("bookingDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad request. No id has been provided.");
        }
        bookingDao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/booking/list");
    }
}