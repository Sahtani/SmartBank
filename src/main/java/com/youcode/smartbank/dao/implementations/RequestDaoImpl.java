package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RequestDaoImpl extends GenericDaoImpl<Request, Long> implements RequestDaoI {


    public RequestDaoImpl() {
        super(Request.class);
    }


    @Override
    public List<RequestStatus> findStatusesByRequestId(Long requestId) {
//        List<RequestStatus> allStatuses = findAll();
//        return allStatuses.stream()
//                .filter(status -> status.getRequestStatuses().stream()
//                        .anyMatch(request -> request.getId().equals(requestId)))
//                .collect(Collectors.toList());
        return List.of();
    }

}
