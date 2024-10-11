package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.GenericDaoI;
import com.youcode.smartbank.utils.EntityManagerProvider;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GenericDaoImpl<T, ID> implements GenericDaoI<T, ID> {
    @Inject
    protected EntityManager em;
    private Class<T> entityType;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    protected EntityManager getEntityManager() {
        return EntityManagerProvider.getInstance().createEntityManager();
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
    public T save(T entity) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
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
