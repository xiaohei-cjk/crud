package com.cjk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("account");
        if (username != null && "admin".equals(username)) {
            session.setAttribute("username", username);
            resp.sendRedirect("/sys/user/allUser");
            return;
        }
        resp.sendRedirect("index.jsp");
        return;
    }
}
