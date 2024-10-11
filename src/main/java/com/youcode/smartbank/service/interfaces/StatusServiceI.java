package com.youcode.smartbank.service.interfaces;
import com.youcode.smartbank.entities.Status;

import java.util.List;
import java.util.Optional;

public interface StatusServiceI {
    Status save(Status status);
    void update(Status status);
    void delete(Status status);
    Optional<Status> getById(Long id);


    List<Status> getAll();
}
