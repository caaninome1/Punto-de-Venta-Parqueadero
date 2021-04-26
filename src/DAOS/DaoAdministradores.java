package DAOS;

import CONTROL.exceptions.NonexistentEntityException;
import CONTROL.exceptions.PreexistingEntityException;
import ENTIDAD.Administradores;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoAdministradores implements Serializable {

    public DaoAdministradores(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parqueadero_v2.0PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DaoAdministradores() {
    }
    
    

    public void create(Administradores administradores) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(administradores);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdministradores(administradores.getIdadministrador()) != null) {
                throw new PreexistingEntityException("El administrador " + administradores + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administradores administradores) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            
            administradores = em.merge(administradores);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administradores.getIdadministrador();
                if (findAdministradores(id) == null) {
                    throw new NonexistentEntityException("The administradores with id " + id + " no longer exists.");
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
            Administradores administradores;
            try {
                administradores = em.getReference(Administradores.class, id);
                administradores.getIdadministrador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administradores with id " + id + " no longer exists.", enfe);
            }
            em.remove(administradores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administradores> findAdministradoresEntities() {
        return findAdministradoresEntities(true, -1, -1);
    }

    public List<Administradores> findAdministradoresEntities(int maxResults, int firstResult) {
        return findAdministradoresEntities(false, maxResults, firstResult);
    }

    private List<Administradores> findAdministradoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administradores.class));
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

    public Administradores findAdministradores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administradores.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administradores> rt = cq.from(Administradores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
