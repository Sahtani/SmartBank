package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.entities.Request;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RequestDaoImpl extends GenericDaoImpl<Request, Long> implements RequestDaoI {


    public RequestDaoImpl() {
        super(Request.class);
    }


}
