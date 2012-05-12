package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.RoleDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.User;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext
	private EntityManager em;

	public void remove(Long id) {
		Role role = getByID(id);
		if (role != null) {
			em.remove(role);	
		}
	}

	public Role getByID(Long id) {
		return em.find(Role.class, id);
	}

	public List<Role> getAll() {
		List<Role> lr = em.createQuery("Select From Role").getResultList();
		lr.size();
		return lr;
	}

	public void addOrUpdate(Role role) {
		em.persist(role);

	}
	
	public void drop()
	{
		em.createQuery("Delete From Role").executeUpdate();
	}
    
    public Role getUserRole(String username)
    {
        return (Role)em.createQuery("Select u.role From User u Where u.name = '"+username+"'").getSingleResult();
    }

    public Role getRoleByName(String name)
    {
        Role role = (Role) em.createQuery(
                "Select From Role Where name='" + name + "'")
                .getSingleResult();
        return role;

    }
    
}