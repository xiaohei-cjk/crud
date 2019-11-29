package com.cjk.servlet;

import com.cjk.entity.User;
import com.cjk.service.userService.UserService;
import com.cjk.service.userServiceImpl.UserServiceImpl;
import com.cjk.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sys/user/allUser")
public class AllUserServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PageBean pageBean=new PageBean<User>();
        pageBean.setPage(req.getParameter("page")==null?1:Integer.valueOf(req.getParameter("page")));
        pageBean.setPageSize(2);

        PageBean<User> userPageBean = userService.findAllUser(pageBean,req.getParameter("account")==null?"": req.getParameter("account").trim());
        userPageBean.setCount(userService.userCount(req.getParameter("account")==null?"": req.getParameter("account").trim()));
        userPageBean.setPageSize(2);
        userPageBean.setPage(pageBean.getPage());
        req.setAttribute("userList",userPageBean.getList());
        req.setAttribute("userPageBean",userPageBean);
        req.setAttribute("account",req.getParameter("account")==null?"": req.getParameter("account").trim());
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);
    }
}
