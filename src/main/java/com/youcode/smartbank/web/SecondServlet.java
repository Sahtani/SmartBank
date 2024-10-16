package com.youcode.smartbank.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        session.setAttribute("email", email);
        session.setAttribute("phone", phone);
        session.setAttribute("username", "JohnDoe");
        response.sendRedirect("credit.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phone");

        if (email == null || phone == null) {
            response.sendRedirect("index1.jsp");
            return;
        }
        response.sendRedirect("credit.jsp");
    }
}
