package com.youcode.smartbank.service.implementations;

import com.youcode.smartbank.entities.RequestStatus;
import com.youcode.smartbank.service.interfaces.RequestStatusServiceI;

import java.util.List;
import java.util.Optional;

public class RequestStatusServiceImpl implements RequestStatusServiceI {

    @Override
    public void save(RequestStatus requestStatus) {

    }

    @Override
    public void update(RequestStatus requestStatus) {

    }

    @Override
    public void delete(RequestStatus requestStatus) {

    }

    @Override
    public Optional<RequestStatus> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<RequestStatus> getAll() {
        return List.of();
    }
}
