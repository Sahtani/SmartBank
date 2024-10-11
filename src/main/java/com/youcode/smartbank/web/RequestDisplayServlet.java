package com.youcode.smartbank.web;

import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import com.youcode.smartbank.service.interfaces.StatusServiceI;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/displayRequests")
public class RequestDisplayServlet extends HttpServlet {

    @Inject
    private RequestServiceI requestService;
    @Inject
    StatusServiceI statusService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet called");
        try {
            List<Request> requests = requestService.getAll();
            List<Status> statuses = statusService.getAll();
            request.setAttribute("requests", requests);
            request.setAttribute("statuses", statuses);
            request.getRequestDispatcher("displayRequests.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Log l'exception
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors du traitement de votre requête.");
        }
    }

}
