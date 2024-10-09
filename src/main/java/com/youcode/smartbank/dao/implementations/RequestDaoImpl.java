package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.entities.Request;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@RequestScoped
public class RequestDaoImpl implements RequestDaoI {

    @Inject
    private EntityManager em;

    @Override
    public void save(Request request) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(request);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to save request", e);
        }
    }

    @Override
    public void update(Request request) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(request);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to update request", e);
        }
    }

    @Override
    public void delete(Request request) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.contains(request) ? request : em.merge(request));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to delete request", e);
        }
    }

    @Override
    public Request getById(String id) {
        try {
            return em.find(Request.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to find request by ID", e);
        }
    }

    @Override
    public List<Request> getAll() {
        try {
            return em.createQuery("SELECT r FROM Request r", Request.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve all requests", e);
        }
    }
}
