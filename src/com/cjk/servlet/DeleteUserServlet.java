package com.cjk.servlet;

import com.cjk.service.userService.UserService;
import com.cjk.service.userServiceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sys/user/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        userService.deleteUserById(Integer.valueOf(id));

        resp.sendRedirect("/sys/user/allUser");
    }
}
