package ru.kpfu.itis.servlet.auth;

import ru.kpfu.itis.dao.UserDao;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile/edit")
public class ProfileEditServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        try {
            req.setAttribute("user", userDao.getUserDetails(userService.getUser(req, resp).getId()));
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/WEB-INF/view/profile/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");

        User user = userService.getUser(req, resp);

        user.setUsername(username);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        try {
            userDao.updateUser(user);
            resp.sendRedirect(req.getContextPath() + "/profile/edit"); // Redirect to profile page after successful update
        } catch (SQLException | DbException e) {
            throw new RuntimeException(e);
        }
    }

}
