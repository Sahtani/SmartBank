package com.youcode.smartbank.service.interfaces;

import com.youcode.smartbank.entities.RequestStatus;

import java.util.List;
import java.util.Optional;

public interface RequestStatusServiceI {
    RequestStatus save(RequestStatus requestStatus);
    void update(RequestStatus requestStatus);
    void delete(RequestStatus requestStatus);
    Optional<RequestStatus> getById(Long id);


    List<RequestStatus> getAll();
}