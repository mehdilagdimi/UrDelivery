package com.urdelivery;

import com.urdelivery.urdelivery.util.HibernateUtil.HibernateUtil;
import com.urdelivery.urdelivery.util.HibernateUtil.Security;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" testing DB CNX");
        HibernateUtil.configure();
        System.out.println(HibernateUtil.isConnected());

        System.out.println(Security.hashPassword("password"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
