package com.youcode.smartbank.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerProvider instance;
    private EntityManagerFactory emf;

    private EntityManagerProvider() {
        emf = Persistence.createEntityManagerFactory("SmartBank");
    }

    public static synchronized EntityManagerProvider getInstance() {
        if (instance == null) {
            instance = new EntityManagerProvider();
        }
        return instance;
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManager() {
        if (instance != null && instance.emf != null && instance.emf.isOpen()) {
            instance.emf.close();
            instance = null;
        }
    }
}
