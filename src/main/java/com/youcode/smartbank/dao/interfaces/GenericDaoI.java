package com.youcode.smartbank.dao.interfaces;

import java.util.List;

public interface GenericDaoI<T, ID> {
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    void update(T entity);
    void delete(T entity);
}
