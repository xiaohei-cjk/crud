package com.cjk.servlet;

import com.cjk.entity.User;
import com.cjk.service.userService.UserService;
import com.cjk.service.userServiceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sys/user/toUpdateUser")
public class ToUpdateUser extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=userService.findUserById(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("user",user);
        req.getRequestDispatcher("/updateUser.jsp").forward(req,resp);
    }
}
