package com.youcode.smartbank.dao.implementations;

import com.youcode.smartbank.dao.interfaces.GenericDaoI;
import com.youcode.smartbank.utils.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class GenericDaoImpl<T, ID> implements GenericDaoI<T, ID> {
    private EntityManager em;
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
        em = getEntityManager();
        T entity = em.find(entityType, id);
        em.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        em = getEntityManager();
        TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType);
        List<T> resultList = query.getResultList();
        em.close();
        return resultList;
    }

    @Override
    public T save(T entity) {
        em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public void update(T entity) {
        em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(T entity) {
        em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
