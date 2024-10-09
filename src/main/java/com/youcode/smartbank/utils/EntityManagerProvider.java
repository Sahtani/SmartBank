package com.youcode.smartbank.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProvider {

    private static EntityManagerFactory emf;

    @Produces
    @ApplicationScoped
    public EntityManager createEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("SmartBank");
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManager() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
