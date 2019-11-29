package com.cjk.servlet;

import com.alibaba.fastjson.JSON;
import com.cjk.entity.City;
import com.cjk.service.cityService.CityService;
import com.cjk.service.cityServiceImpl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/city")
public class AllCityServlet extends HttpServlet {
    CityService cityService=new CityServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> cityList = cityService.getAllById(req.getParameter("id") == null ? 0 : Integer.valueOf(req.getParameter("id")));

        resp.getWriter().print(JSON.toJSONString(cityList));
    }
}
