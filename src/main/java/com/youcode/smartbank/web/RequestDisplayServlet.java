package com.youcode.smartbank.web;

import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet called");
        try {
            List<Request> requests = requestService.getAll();
            System.out.println(requests.size());
            System.out.println("requests");
            for (Request req : requests) {
                System.out.println(req); // Vous pouvez personnaliser cette ligne si vous avez une méthode toString() dans votre classe Request
            }

            request.setAttribute("requests", requests);
            request.getRequestDispatcher("displayRequests.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Log l'exception
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors du traitement de votre requête.");
        }
    }

}
