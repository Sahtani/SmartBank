package com.youcode.smartbank.service.interfaces;

import com.youcode.smartbank.entities.Request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RequestServiceI {

    Request save(Request request);
    Optional<Request> getById(Long id);
    Double calculerMensualite(BigDecimal capital, int dureeEnMois);
    List<Request> getAll();
    List<Request> findRequestsByDateAndStatus(LocalDate date, String status);
}
