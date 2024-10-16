package com.youcode.smartbank.dao.interfaces;

import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;

import java.time.LocalDate;
import java.util.List;

public interface RequestDaoI extends GenericDaoI<Request, Long> {
    List<Request> findCreditsByDateAndStatus(LocalDate date, String status);
}
