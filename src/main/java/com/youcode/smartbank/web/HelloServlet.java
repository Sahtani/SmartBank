package com.youcode.smartbank.web;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.youcode.smartbank.entities.Request;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private EntityManagerFactory emf;

    public void init() {
        // Initialisation de l'EntityManagerFactory
        emf = Persistence.createEntityManagerFactory("creditApp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parsing des paramètres du formulaire
        String project = request.getParameter("project");
        String status = request.getParameter("status");
        double amount = Double.parseDouble(request.getParameter("amount"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        double monthlyPayment = Double.parseDouble(request.getParameter("monthlyPayment"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String title = request.getParameter("title");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String idNumber = request.getParameter("idNumber");

        // Parsing des dates avec SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        Date employmentStartDate = null;
        try {
            dateOfBirth = sdf.parse(request.getParameter("dateOfBirth"));
            employmentStartDate = sdf.parse(request.getParameter("employmentStartDate"));
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Format de date invalide.");
            return;
        }

        double monthlyIncome = Double.parseDouble(request.getParameter("monthlyIncome"));
        boolean hasExistingLoans = Boolean.parseBoolean(request.getParameter("hasExistingLoans"));

        EntityManager em = emf.createEntityManager();
        try {
            // Démarrage de la transaction
            em.getTransaction().begin();

            // Création de la demande de crédit
            Request creditRequest = new Request();
            creditRequest.setProject(project);
            creditRequest.setStatus(status);
            creditRequest.setAmount(amount);
            creditRequest.setDuration(duration);
            creditRequest.setMonthlyPayment(monthlyPayment);
            creditRequest.setEmail(email);
            creditRequest.setPhone(phone);
            creditRequest.setTitle(title);
            creditRequest.setLastName(lastName);
            creditRequest.setFirstName(firstName);
            creditRequest.setIdNumber(idNumber);
            creditRequest.setDateOfBirth(dateOfBirth);
            creditRequest.setEmploymentStartDate(employmentStartDate);
            creditRequest.setMonthlyIncome(monthlyIncome);
            creditRequest.setHasExistingLoans(hasExistingLoans);

            // Persistance dans la base de données
            em.persist(creditRequest);

            // Validation de la transaction
            em.getTransaction().commit();

            // Redirection vers une page de succès
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            // Gestion des erreurs
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la création de la demande.");
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }
}
