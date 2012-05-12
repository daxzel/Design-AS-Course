package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.RoleDAO;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.User;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

	public void remove(Long id) {

        EntityManager em = emf.createEntityManager();
		Role role = getByID(id);
		if (role != null) {
			em.remove(role);	
		}
        em.close();
	}

	public Role getByID(Long id) {

        EntityManager em = emf.createEntityManager();
		Role role = em.find(Role.class, id);
        em.close();
        return role;
	}

	public List<Role> getAll() {
        EntityManager em = emf.createEntityManager();
		List<Role> lr = em.createQuery("Select From Role").getResultList();
		lr.size();
        em.close();
		return lr;
	}

	public void addOrUpdate(Role role) {
        EntityManager em = emf.createEntityManager();
		em.persist(role);
        em.close();

	}
	
	public void drop()
	{
        EntityManager em = emf.createEntityManager();
		em.createQuery("Delete From Role").executeUpdate();
        em.close();
	}
    
    public Role getUserRole(String username)
    {
        EntityManager em = emf.createEntityManager();
        Role role = (Role)em.createQuery("Select u.role From User u Where u.name = '"+username+"'").getSingleResult();
        em.close();
        return role;
    }

    public Role getRoleByName(String name)
    {
        EntityManager em = emf.createEntityManager();
        Role role = (Role) em.createQuery(
                "Select From Role Where name='" + name + "'")
                .getSingleResult();
        em.close();
        return role;

    }
    
}