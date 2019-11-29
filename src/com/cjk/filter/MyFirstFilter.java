package com.cjk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class MyFirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;UTF-8");
        servletResponse.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String uri=request.getRequestURI();

        if (uri.equals("/index.jsp")||uri.equals("/login")||uri.equals("/")){
            filterChain.doFilter(request,response);
            return;
        }

        if (null != session.getAttribute("username")&&"admin".equals(session.getAttribute("username"))) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            response.sendRedirect("/index.jsp");
            return;
        }


    }

    @Override
    public void destroy() {

    }
}
