package com.youcode.smartbank.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // System.out.println("Form submitted successfully");
        HttpSession session = request.getSession();
        String projectType = request.getParameter("project");
        String position = request.getParameter("status");
        String amount = request.getParameter("amount");
     //   float amount = (amountObj != null) ? amountObj.floatValue() : 0.0f;

        int durationsInMonths = Integer.parseInt(request.getParameter("duration"));
        BigDecimal monthlyIncome = new BigDecimal(request.getParameter("monthly"));

        session.setAttribute("projectType", projectType);
        session.setAttribute("status", position);
        session.setAttribute("amount", amount);
        session.setAttribute("duration", durationsInMonths);
        session.setAttribute("monthly", monthlyIncome);

        response.sendRedirect("summary.jsp");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String projectType = (String) session.getAttribute("projectType");
        String position = (String) session.getAttribute("position");
        double amount = (double) session.getAttribute("amount");
        int durationsInMonths = (Integer) session.getAttribute("durationsInMonths");
        BigDecimal monthlyIncome = (BigDecimal) session.getAttribute("monthlyIncome");
        response.sendRedirect("summary.jsp");
    }
}
