package com.youcode.smartbank.service.interfaces;

import com.youcode.smartbank.entities.Request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RequestServiceI {

    Request save(Request request);
    void update(Request request);
    void delete(Request request);
    Optional<Request> getById(Long id);
    Double calculerMensualite(BigDecimal capital, int dureeEnMois);

    List<Request> getAll();
}
