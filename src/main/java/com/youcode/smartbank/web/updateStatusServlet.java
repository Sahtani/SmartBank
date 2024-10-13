package com.youcode.smartbank.web;

import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import com.youcode.smartbank.service.interfaces.RequestStatusServiceI;
import com.youcode.smartbank.service.interfaces.StatusServiceI;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@WebServlet(name = "updateStatusServlet", value = "/updateStatusServlet")
public class updateStatusServlet extends HttpServlet {

    @Inject
    private RequestServiceI requestService;

    @Inject
    private StatusServiceI statusService;

    @Inject
    private RequestStatusServiceI requestStatusServiceI;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long idCredit = Long.parseLong(request.getParameter("requestId"));
        Long idStatus = Long.parseLong(request.getParameter("status"));
        String explication = request.getParameter("description");

        Optional<Request> newCredit = requestService.getById(idCredit);

        Optional<RequestStatus> statusActuel = newCredit.get().getRequestStatuses().stream()
                .max(Comparator.comparing(RequestStatus::getDate));

        Optional<Status> newStatus = statusService.getById(idStatus);
        RequestStatus requestStatus = new RequestStatus();
        requestStatus.setRequest(newCredit.get());
        requestStatus.setStatus(newStatus.get());
        requestStatus.setDescription(explication);
        requestStatus.setDate(LocalDate.from(LocalDateTime.now()));

        if (statusActuel.isPresent()) {
            RequestStatus latestStatus = statusActuel.get();
            if (latestStatus.getStatus().getStatus().equals(newStatus.get().getStatus())) {
                session.setAttribute("flashMessage", "Le statut n’a pas été modifié, puisqu’il est déjà le même");
                response.sendRedirect("displayRequests");
            } else {
                RequestStatus listRequestStatus = requestStatusServiceI.save(requestStatus);
                newCredit.get().getRequestStatuses().add(listRequestStatus);
                session.setAttribute("flashMessage", "Le statut a été modifié avec succès");
                response.sendRedirect("displayRequests");
            }
        } else {
            session.setAttribute("flashMessage", "Aucun statut actuel trouvé");
            response.sendRedirect("displayRequests");
        }
    }
}