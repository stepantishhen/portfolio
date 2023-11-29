package ru.kpfu.itis.servlet.auth;

import ru.kpfu.itis.dao.UserDao;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.ConnectionProvider;
import ru.kpfu.itis.util.DbException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = (UserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/security/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/register?error=invalidInput");
            return;
        }

        User user = User.builder()
                .username(username)
                .password(password)
                .role("simpleuser")
                .build();
        try {
            userDao.registerUser(user);
            response.sendRedirect(request.getContextPath() + "/signin");
        } catch (DbException e) {
            request.setAttribute("error", "Username already exist!");
            response.sendRedirect(request.getContextPath() + "/register?error=usernameExist");

        }
//        request.getRequestDispatcher("/WEB-INF/view/security/registration.jsp").forward(request, response);
    }
}
