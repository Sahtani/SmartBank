package com.youcode.smartbank.service.implementations;

import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.entities.Request;
import com.youcode.smartbank.entities.RequestStatus;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class RequestServiceImpl implements RequestServiceI {
    @Inject
    private RequestDaoI requestDao;

    private final Validator validator;

    public RequestServiceImpl() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public Request save(Request request) {
        validateRequest(request);
       return requestDao.save(request);

    }

    @Override
    public Optional<Request> getById(Long id){
        return Optional.ofNullable(requestDao.findById(id));
    }

    @Override
    public List<Request> getAll() {
        return requestDao.findAll();
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
    @Override
    public Double calculerMensualite(BigDecimal capital, int dureeEnMois) {
        BigDecimal tauxAnnuel = BigDecimal.valueOf(0.12);
        BigDecimal tauxMensuel = tauxAnnuel.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

        BigDecimal puissance = BigDecimal.valueOf(Math.pow(1 + tauxMensuel.doubleValue(), -dureeEnMois));

        BigDecimal denominateur = BigDecimal.ONE.subtract(puissance);

        BigDecimal mensualite = capital.multiply(tauxMensuel).divide(denominateur, 2, RoundingMode.HALF_UP);

        return mensualite.doubleValue();
    }

    @Override
    public List<Request> findRequestsByDateAndStatus(LocalDate date, String status) {
        return requestDao.findCreditsByDateAndStatus(date, status);
    }


}
