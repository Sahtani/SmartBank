package com.youcode.smartbank.service.implementations;

import com.youcode.smartbank.dao.interfaces.StatusDaoI;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.interfaces.StatusServiceI;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class StatusServiceImpl implements StatusServiceI {

    @Inject
    private StatusDaoI statusDaoI;


    @Override
    public Status save(Status status) {
        return statusDaoI.save(status);


    }

    @Override
    public void update(Status status) {

    }

    @Override
    public void delete(Status status) {

    }

    @Override
    public Optional<Status> getById(Long id) {
        return Optional.ofNullable(statusDaoI.findById(id));
    }


    @Override
    public List<Status> getAll() {
        return List.of();
    }
}
