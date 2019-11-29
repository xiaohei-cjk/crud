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

@WebServlet("/sys/user/updateUser")
public class UpdateUser extends HttpServlet {

    private UserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        user.setId(Integer.valueOf(req.getParameter("id")));
        user.setAccount(req.getParameter("account"));
        user.setName(req.getParameter("name"));
        user.setAge(Integer.valueOf(req.getParameter("age")));
        user.setSex(Integer.valueOf(req.getParameter("sex")));
        user.setBirthday(req.getParameter("birthday"));

        userService.updateUser(user);

        resp.sendRedirect("/sys/user/allUser");
    }
}
