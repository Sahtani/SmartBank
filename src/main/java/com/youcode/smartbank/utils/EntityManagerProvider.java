package com.youcode.smartbank.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private EntityManagerProvider() {
    }

    public static EntityManager getEntityManager() {
        if (em == null) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("SmartBank");
            }
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
