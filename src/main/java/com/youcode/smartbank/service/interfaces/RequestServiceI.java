package com.youcode.smartbank.service.interfaces;

import com.youcode.smartbank.entities.Request;

import java.util.List;
import java.util.Optional;

public interface RequestServiceI {

    void save(Request request);
    void update(Request request);
    void delete(Request request);
    Optional<Request> getById(Long id);


    List<Request> getAll();
}
