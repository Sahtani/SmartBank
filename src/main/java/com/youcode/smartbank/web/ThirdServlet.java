package com.youcode.smartbank.web;


import com.youcode.smartbank.dao.implementations.RequestDaoImpl;
import com.youcode.smartbank.entities.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/thirdServlet")
public class ThirdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ThirdServlet doPost called");
        HttpSession session = request.getSession();

        String projectType = (String) session.getAttribute("projectType");
        String position = (String) session.getAttribute("status");
        double amount = (double) session.getAttribute("amount");
        int durationInMonths = (Integer) session.getAttribute("duration");
        BigDecimal monthlyPayment = (BigDecimal) session.getAttribute("monthly");
        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phone");

        String civility = request.getParameter("civilite");
        String firstName = request.getParameter("nom");
        String lastName = request.getParameter("prenom");
        String cin = request.getParameter("cin");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String birthDateStr = request.getParameter("date_naissance");
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
        String startEmploymentDateStr = request.getParameter("date_embauche");
        LocalDate startEmployementDate = LocalDate.parse(startEmploymentDateStr, formatter);
        String monthlyPaymentStr = request.getParameter("revenus");
        BigDecimal monthlyIncome = new BigDecimal(monthlyPaymentStr);
        String hasActivateCreditsStr = request.getParameter("credit_en_cours");
        boolean hasActivateCredits = Boolean.parseBoolean(hasActivateCreditsStr);

        Request newRequest = new Request();
        newRequest.setProject(projectType);
        newRequest.setStatus(position);
        newRequest.setAmount(amount);
        newRequest.setDuration(durationInMonths);
        newRequest.setMonthlyPayment(monthlyPayment);
        newRequest.setEmail(email);
        newRequest.setPhone(phone);
        newRequest.setTitle(civility);
        newRequest.setFirstName(firstName);
        newRequest.setLastName(lastName);
        newRequest.setCin(cin);
        newRequest.setDateOfBirth(birthDate);
        newRequest.setEmploymentStartDate(startEmployementDate);
        newRequest.setMonthlyPayment(monthlyIncome);
        newRequest.setHasExistingLoans(hasActivateCredits);


        RequestDaoImpl requestDao = new RequestDaoImpl();

        try {
            // Enregistrement de la demande
            requestDao.save(newRequest);
            response.sendRedirect("succes.jsp");
            request.setAttribute("successMessage", "Votre demande a été soumise avec succès !");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Une erreur est survenue lors de la soumission de votre demande.");
        }

        // Rediriger vers la page de confirmation ou d'affichage des messages
        request.getRequestDispatcher("credit.jsp").forward(request, response);
    }
}
