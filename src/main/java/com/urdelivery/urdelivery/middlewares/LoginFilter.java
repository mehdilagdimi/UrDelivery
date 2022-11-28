package com.urdelivery.urdelivery.middlewares;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/secured/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig config){

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Inside Login Filter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        System.out.println("session..."+ session);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/loginPage.xhtml");
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }

}
