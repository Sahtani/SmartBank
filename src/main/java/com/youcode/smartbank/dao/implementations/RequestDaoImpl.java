package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RequestDaoImpl extends GenericDaoImpl<Request, Long> implements RequestDaoI {


    public RequestDaoImpl() {
        super(Request.class);
    }


    @Override
    public List<Request> findCreditsByDateAndStatus(LocalDate date, String status) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Request> requests = new ArrayList<>();

        try {
            transaction.begin();
            String query = "SELECT r FROM Request r JOIN r.requestStatuses s WHERE s.date = :date AND s.status.status = :status";
            requests = em.createQuery(query, Request.class)
                    .setParameter("date", date)
                    .setParameter("status", status)
                    .getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

        return requests;
    }



}
