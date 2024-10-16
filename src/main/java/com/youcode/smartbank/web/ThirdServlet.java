package com.youcode.smartbank.web;

import com.youcode.smartbank.dao.implementations.RequestDaoImpl;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import com.youcode.smartbank.service.interfaces.RequestStatusServiceI;
import com.youcode.smartbank.service.interfaces.StatusServiceI;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.inject.Inject;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@WebServlet("/displayRequests")
public class ThirdServlet extends HttpServlet {

    @Inject
    private RequestServiceI requestService;

    @Inject
    private StatusServiceI statusService;

    @Inject
    private RequestStatusServiceI requestStatusServiceI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String dateParam = request.getParameter("date");
            String statusParam = request.getParameter("status");
            HttpSession session = request.getSession();
            session.setAttribute("date", dateParam);
            session.setAttribute("status", statusParam);

            List<Request> requests;

            if (dateParam != null && !dateParam.isEmpty() && statusParam != null && !statusParam.isEmpty()) {
                LocalDate date = LocalDate.parse(dateParam);
                requests = requestService.findRequestsByDateAndStatus(date, statusParam);
            } else {
                requests = requestService.getAll();
            }

            List<Status> statuses = statusService.getAll();
            request.setAttribute("requests", requests);
            request.setAttribute("statuses", statuses);
            request.getRequestDispatcher("displayRequests.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            String projectType = (String) session.getAttribute("projectType");
            String position = (String) session.getAttribute("status");
            String amountStr = (String) session.getAttribute("amount");
            double amount = Double.parseDouble(amountStr);

            int durationInMonths = Integer.parseInt(session.getAttribute("duration").toString());
            BigDecimal monthlyPayment = new BigDecimal(session.getAttribute("monthly").toString());

            String email = (String) session.getAttribute("email");
            String phone = (String) session.getAttribute("phone");


            String civility = request.getParameter("civilite");
            String firstName = request.getParameter("nom");
            String lastName = request.getParameter("prenom");
            String cin = request.getParameter("cin");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate birthDate = LocalDate.parse(request.getParameter("date_naissance"), formatter);
            LocalDate startEmploymentDate = LocalDate.parse(request.getParameter("date_embauche"), formatter);

            double monthlyIncome = Double.parseDouble(request.getParameter("revenus"));
            boolean hasActiveCredits = Boolean.parseBoolean(request.getParameter("credit_en_cours"));

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
            newRequest.setEmploymentStartDate(startEmploymentDate);
            newRequest.setMonthlyIncome(monthlyIncome);
            newRequest.setHasExistingLoans(hasActiveCredits);

            System.out.println("Processing new request");

            Request requestCreated = requestService.save(newRequest);
            Optional<Status> newStatus = statusService.getById(1L);

            if (newStatus.isPresent()) {
                RequestStatus requestStatus = new RequestStatus();
                requestStatus.setDate(LocalDate.now());
                requestStatus.setRequest(requestCreated);
                requestStatus.setStatus(newStatus.get());
                requestStatus.setDescription("La demande de crédit a été soumise et est en attente.");

                RequestStatus statusDefault = requestStatusServiceI.save(requestStatus);
                requestCreated.getRequestStatuses().add(statusDefault);


                for (RequestStatus status : newRequest.getRequestStatuses()) {
                    System.out.println("Date: " + status.getDate() + ", Status: " +
                            status.getStatus().getStatus() + ", Description: " + status.getDescription());
                }

                request.setAttribute("successMessage", "Your request has been successfully submitted!");
                response.sendRedirect("success.jsp");

            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while submitting your request.");
            request.getRequestDispatcher("displayRequests.jsp").forward(request, response);
        }
    }
}
