package com.youcode.smartbank.service.implementations;

import com.youcode.smartbank.dao.interfaces.RequestStatusDaoI;
import com.youcode.smartbank.dao.interfaces.StatusDaoI;
import com.youcode.smartbank.entities.RequestStatus;
import com.youcode.smartbank.service.interfaces.RequestStatusServiceI;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class RequestStatusServiceImpl implements RequestStatusServiceI {
    @Inject
    private RequestStatusDaoI requestStatusDaoI;
    @Override
    public RequestStatus save(RequestStatus requestStatus) {
       return requestStatusDaoI.save(requestStatus);
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
