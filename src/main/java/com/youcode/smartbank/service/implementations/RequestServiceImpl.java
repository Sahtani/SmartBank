package com.youcode.smartbank.service.implementations;

import com.youcode.smartbank.dao.implementations.RequestDaoImpl;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class RequestServiceImpl implements RequestServiceI {
    @Inject
    private RequestDaoImpl requestDao;

    private final Validator validator;

    public RequestServiceImpl() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public void save(Request request) {
        validateRequest(request);
        requestDao.save(request);

    }

    @Override
    public void update(Request request) {

    }

    @Override
    public void delete(Request request) {

    }

    @Override
    public Request getById(String id) {
        return null;
    }

    @Override
    public List<Request> getAll() {
        System.out.println("RequestServiceImpl.getAll() called"); // Log simple
        return requestDao.getAll();
    }

    private void validateRequest(Request request) {
        Set<ConstraintViolation<Request>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Request> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
