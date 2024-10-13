package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.StatusDaoI;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;
import com.youcode.smartbank.entities.Status;

import java.util.List;

public class StatusDaoImpl extends GenericDaoImpl<Status, Long> implements StatusDaoI {


    public StatusDaoImpl() {
        super(Status.class);
    }


}
