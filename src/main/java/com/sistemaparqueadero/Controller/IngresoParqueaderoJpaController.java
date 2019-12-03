/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.Controller;

import com.sistemaparqueadero.Controller.exceptions.NonexistentEntityException;
import com.sistemaparqueadero.entity.IngresoParqueadero;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author manue
 */
public class IngresoParqueaderoJpaController implements Serializable {

    public IngresoParqueaderoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IngresoParqueadero ingresoParqueadero) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ingresoParqueadero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IngresoParqueadero ingresoParqueadero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ingresoParqueadero = em.merge(ingresoParqueadero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ingresoParqueadero.getIdingresoParqueadero();
                if (findIngresoParqueadero(id) == null) {
                    throw new NonexistentEntityException("The ingresoParqueadero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IngresoParqueadero ingresoParqueadero;
            try {
                ingresoParqueadero = em.getReference(IngresoParqueadero.class, id);
                ingresoParqueadero.getIdingresoParqueadero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ingresoParqueadero with id " + id + " no longer exists.", enfe);
            }
            em.remove(ingresoParqueadero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IngresoParqueadero> findIngresoParqueaderoEntities() {
        return findIngresoParqueaderoEntities(true, -1, -1);
    }

    public List<IngresoParqueadero> findIngresoParqueaderoEntities(int maxResults, int firstResult) {
        return findIngresoParqueaderoEntities(false, maxResults, firstResult);
    }

    private List<IngresoParqueadero> findIngresoParqueaderoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IngresoParqueadero.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public IngresoParqueadero findIngresoParqueadero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IngresoParqueadero.class, id);
        } finally {
            em.close();
        }
    }

    public int getIngresoParqueaderoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IngresoParqueadero> rt = cq.from(IngresoParqueadero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
