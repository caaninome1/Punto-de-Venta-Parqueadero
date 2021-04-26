package DAOS;

import CONTROL.exceptions.NonexistentEntityException;
import CONTROL.exceptions.PreexistingEntityException;
import ENTIDAD.Parqueadero;
import java.io.Serializable;
import java.security.AccessControlException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoParqueadero implements Serializable {

    public DaoParqueadero(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parqueadero_v2.0PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DaoParqueadero() {
    }

    public void create(Parqueadero parqueadero) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(parqueadero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParqueadero(parqueadero.getNit()) != null) {
                throw new PreexistingEntityException("Parqueadero " + parqueadero + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Parqueadero parqueadero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = parqueadero.getNit();
            if (findParqueadero(id) == null) {
                throw new NonexistentEntityException("El parqueadero con id " + id + " no existe.");
            }else{
                parqueadero = em.merge(parqueadero);
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
            Parqueadero parqueadero;
            try {
                parqueadero = em.getReference(Parqueadero.class, id);
                parqueadero.getNit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parqueadero with id " + id + " no longer exists.", enfe);
            }
            em.remove(parqueadero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Parqueadero> findParqueaderoEntities() {
        return findParqueaderoEntities(true, -1, -1);
    }

    public List<Parqueadero> findParqueaderoEntities(int maxResults, int firstResult) {
        return findParqueaderoEntities(false, maxResults, firstResult);
    }

    private List<Parqueadero> findParqueaderoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Parqueadero.class));
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

    public Parqueadero findParqueadero(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Parqueadero.class, id);
        } finally {
            em.close();
        }
    }

    public int getParqueaderoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Parqueadero> rt = cq.from(Parqueadero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
