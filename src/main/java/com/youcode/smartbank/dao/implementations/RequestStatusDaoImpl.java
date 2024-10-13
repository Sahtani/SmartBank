package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestStatusDaoI;
import com.youcode.smartbank.entities.RequestStatus;

public class RequestStatusDaoImpl extends GenericDaoImpl<RequestStatus, Long> implements RequestStatusDaoI {

    public RequestStatusDaoImpl() {
        super(RequestStatus.class);
    }

}
