/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entities.CompetenciaTabla;
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
 * @author demozath
 */
public class CompetenciaTablaDAO implements Serializable {

    public CompetenciaTablaDAO(EntityManagerFactory emf) {
  
        this.emf = emf;
    }
    
    public CompetenciaTablaDAO() {
 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompetenciaTabla competenciaTabla) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.persist(competenciaTabla);
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCompetenciaTabla(competenciaTabla.getRut()) != null) {
                throw new PreexistingEntityException("CompetenciaTabla " + competenciaTabla + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CompetenciaTabla competenciaTabla) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            competenciaTabla = em.merge(competenciaTabla);
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = competenciaTabla.getRut();
                if (findCompetenciaTabla(id) == null) {
                    throw new NonexistentEntityException("The competenciaTabla with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CompetenciaTabla competenciaTabla;
            try {
                competenciaTabla = em.getReference(CompetenciaTabla.class, id);
                competenciaTabla.getRut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The competenciaTabla with id " + id + " no longer exists.", enfe);
            }
            em.remove(competenciaTabla);
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompetenciaTabla> findCompetenciaTablaEntities() {
        return findCompetenciaTablaEntities(true, -1, -1);
    }

    public List<CompetenciaTabla> findCompetenciaTablaEntities(int maxResults, int firstResult) {
        return findCompetenciaTablaEntities(false, maxResults, firstResult);
    }

    private List<CompetenciaTabla> findCompetenciaTablaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompetenciaTabla.class));
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

    public CompetenciaTabla findCompetenciaTabla(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompetenciaTabla.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompetenciaTablaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompetenciaTabla> rt = cq.from(CompetenciaTabla.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
