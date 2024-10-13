package com.youcode.smartbank.web;

import com.youcode.smartbank.service.interfaces.RequestServiceI;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
    @Inject
    private RequestServiceI requestService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String projectType = request.getParameter("project");
        String position = request.getParameter("status");
        String amount = request.getParameter("amount");
        BigDecimal amountDecimal = new BigDecimal(amount);


        int durationsInMonths = Integer.parseInt(request.getParameter("duration"));
        BigDecimal monthlyIncome = new BigDecimal(request.getParameter("monthly"));
        Double monthly_Backend = requestService.calculerMensualite(amountDecimal, durationsInMonths);
        BigDecimal monthlyBackendDecimal = BigDecimal.valueOf(monthly_Backend);

        session.setAttribute("projectType", projectType);
        session.setAttribute("status", position);
        session.setAttribute("amount", amount);
        session.setAttribute("duration", durationsInMonths);

        if (!monthlyIncome.equals(monthlyBackendDecimal)) {
            session.setAttribute("monthly", monthly_Backend);
        } else {
            session.setAttribute("monthly", monthlyIncome);
        }
        session.setAttribute("Message", monthly_Backend.toString());
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
