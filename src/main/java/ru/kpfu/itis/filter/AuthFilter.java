package ru.kpfu.itis.filter;

import ru.kpfu.itis.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    private static final String[] securedPaths = new String[]{
            "/file/list",
            "/file/detail",
            "/photostudio/list",
            "/photostudio/detail",
            "/review/create",
            "/review/list",
            "/review/detail",
            "/booking/create",
            "/booking/list",
            "/booking/detail",
            "/profile/edit",
    };
    private static final String[] adminPaths = new String[]{
            "/file/create",
            "/file/delete",
            "/photostudio/create",
            "/photostudio/delete",
            "/booking/delete",
            "/user/list",
            "/user/delete",
    };
    private UserService userService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean prot = false;
        boolean admin = false;
        for (String path : securedPaths) {
            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
                prot = true;
                break;
            }
        }
        for (String path : adminPaths) {
            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
                admin = true;
                break;
            }
        }
        if ((prot || admin) && !userService.isNonAnonymous(req, res)) {
            res.sendRedirect(req.getContextPath() + "/signin");
            return;
        } else {
            if (userService.isNonAnonymous(req, res)) {
                req.setAttribute("user", userService.getUser(req, res));
                if (admin && !userService.isAdmin(req, res)) {
                    res.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Forbidden");
                    return;
                }
            }
            chain.doFilter(req, res);
        }
    }
}
