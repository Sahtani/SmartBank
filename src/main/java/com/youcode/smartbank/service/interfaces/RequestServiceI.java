package com.youcode.smartbank.service.interfaces;

import com.youcode.smartbank.entities.Request;

import java.util.List;

public interface RequestServiceI {

    void save(Request request);
    void update(Request request);
    void delete(Request request);
    Request getById(String id);
    List<Request> getAll();
}
