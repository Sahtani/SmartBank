package com.youcode.smartbank.dao.interfaces;

import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;

import java.util.List;

public interface RequestDaoI extends GenericDaoI<Request, Long> {
    List<RequestStatus> findStatusesByRequestId(Long requestId);

}
