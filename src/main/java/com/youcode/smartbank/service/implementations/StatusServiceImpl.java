package com.youcode.smartbank.service.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.dao.interfaces.StatusDaoI;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.interfaces.StatusServiceI;
import jakarta.inject.Inject;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.List;
import java.util.Optional;

public class StatusServiceImpl implements StatusServiceI {

   // @Inject
    private StatusDaoI statusDaoI;

    public StatusServiceImpl(StatusDaoI statusDao) {
        this.statusDaoI = statusDao;
    }


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
        return Optional.empty();
    }

    @Override
    public List<Status> getAll() {
        return List.of();
    }
}
