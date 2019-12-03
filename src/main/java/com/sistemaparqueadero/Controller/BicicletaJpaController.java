/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.Controller;

import com.sistemaparqueadero.Controller.exceptions.NonexistentEntityException;
import com.sistemaparqueadero.entity.Bicicleta;
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
public class BicicletaJpaController implements Serializable {

    public BicicletaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bicicleta bicicleta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bicicleta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bicicleta bicicleta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bicicleta = em.merge(bicicleta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bicicleta.getIdbicicleta();
                if (findBicicleta(id) == null) {
                    throw new NonexistentEntityException("The bicicleta with id " + id + " no longer exists.");
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
            Bicicleta bicicleta;
            try {
                bicicleta = em.getReference(Bicicleta.class, id);
                bicicleta.getIdbicicleta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bicicleta with id " + id + " no longer exists.", enfe);
            }
            em.remove(bicicleta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bicicleta> findBicicletaEntities() {
        return findBicicletaEntities(true, -1, -1);
    }

    public List<Bicicleta> findBicicletaEntities(int maxResults, int firstResult) {
        return findBicicletaEntities(false, maxResults, firstResult);
    }

    private List<Bicicleta> findBicicletaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bicicleta.class));
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

    public Bicicleta findBicicleta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bicicleta.class, id);
        } finally {
            em.close();
        }
    }

    public int getBicicletaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bicicleta> rt = cq.from(Bicicleta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
