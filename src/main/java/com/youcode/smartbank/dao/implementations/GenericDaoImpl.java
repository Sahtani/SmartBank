package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.GenericDao;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {
    @Inject
    protected EntityManager em;
    private Class<T> entityType;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public T findById(ID id) {
        return em.find(entityType, id);
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType);
        return query.getResultList();
    }

    @Override
    public void save(T entity) {
        em.persist(entity);

    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));

    }
}
