package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDao;
import com.youcode.smartbank.entities.Request;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class RequestDaoImpl extends GenericDaoImpl<Request, Long> implements RequestDao {


    public RequestDaoImpl() {
        super(Request.class);
    }

    // CDI-injected constructor
    @Inject
    public void init(EntityManager entityManager) {
        setEntityManager(entityManager);
    }
}
