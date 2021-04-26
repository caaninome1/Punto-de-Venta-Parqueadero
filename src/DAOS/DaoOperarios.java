package DAOS;

import CONTROL.exceptions.NonexistentEntityException;
import ENTIDAD.Operarios;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoOperarios implements Serializable {

    public DaoOperarios(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parqueadero_v2.0PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DaoOperarios() {
    }
    
    

    public void create(Operarios operarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(operarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Operarios operarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = operarios.getId();
            if (findOperarios(id) == null) {
                throw new NonexistentEntityException("El operario con id " + id + " no existe.");
            }else{            
                operarios = em.merge(operarios);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Operarios operarios;
            try {
                operarios = em.getReference(Operarios.class, id);
                operarios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El operario con id " + id + " no existe.", enfe);
            }
            em.remove(operarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Operarios> findOperariosEntities() {
        return findOperariosEntities(true, -1, -1);
    }

    public List<Operarios> findOperariosEntities(int maxResults, int firstResult) {
        return findOperariosEntities(false, maxResults, firstResult);
    }

    private List<Operarios> findOperariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Operarios.class));
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

    public Operarios findOperarios(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Operarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getOperariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Operarios> rt = cq.from(Operarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
