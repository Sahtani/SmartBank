package com.youcode.smartbank;

import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import jakarta.enterprise.inject.spi.CDI; // Assurez-vous d'importer ceci

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        // Récupérer une instance de RequestServiceI via CDI
        RequestServiceI requestService = CDI.current().select(RequestServiceI.class).get();

        // Récupérer toutes les requêtes
        List<Request> requests = requestService.getAll();

        // Afficher les requêtes
        if (requests != null && !requests.isEmpty()) {
            System.out.println("Requests retrieved successfully:");
            for (Request req : requests) {
                System.out.println(req); // Assurez-vous que la méthode toString() est correctement implémentée dans Request
            }
        } else {
            System.out.println("No requests found.");
        }
    }
}
