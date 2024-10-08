package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.utils.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class RequestDaoImpl implements RequestDaoI {
    @Override
    public void save(Request request) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(request); // stores the request
            transaction.commit(); //valide the operation
        }catch(Exception e){
            if(transaction.isActive()) transaction.rollback();
        }finally{
            em.close();
        }

    }

    @Override
    public void update(Request request) {

    }

    @Override
    public void delete(Request request) {

    }

    @Override
    public Request getById(String id) {
        return null;
    }

    @Override
    public List<Request> getAll() {
        return List.of();
    }
}
