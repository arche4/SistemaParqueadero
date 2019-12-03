/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.Controller;

import com.sistemaparqueadero.Controller.exceptions.NonexistentEntityException;
import com.sistemaparqueadero.entity.EmpleadoVehiculo;
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
public class EmpleadoVehiculoJpaController implements Serializable {

    public EmpleadoVehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpleadoVehiculo empleadoVehiculo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleadoVehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpleadoVehiculo empleadoVehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleadoVehiculo = em.merge(empleadoVehiculo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleadoVehiculo.getIdempleadoVehiculo();
                if (findEmpleadoVehiculo(id) == null) {
                    throw new NonexistentEntityException("The empleadoVehiculo with id " + id + " no longer exists.");
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
            EmpleadoVehiculo empleadoVehiculo;
            try {
                empleadoVehiculo = em.getReference(EmpleadoVehiculo.class, id);
                empleadoVehiculo.getIdempleadoVehiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleadoVehiculo with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleadoVehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmpleadoVehiculo> findEmpleadoVehiculoEntities() {
        return findEmpleadoVehiculoEntities(true, -1, -1);
    }

    public List<EmpleadoVehiculo> findEmpleadoVehiculoEntities(int maxResults, int firstResult) {
        return findEmpleadoVehiculoEntities(false, maxResults, firstResult);
    }

    private List<EmpleadoVehiculo> findEmpleadoVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpleadoVehiculo.class));
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

    public EmpleadoVehiculo findEmpleadoVehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpleadoVehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpleadoVehiculo> rt = cq.from(EmpleadoVehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
