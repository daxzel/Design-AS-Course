package daxzel.model.DAO.impl;

import daxzel.model.DAO.RoleDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.QueryBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Expression;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;
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
		
		List<Role> lr = em.createQuery("Select r From Role r").getResultList();
		lr.size();
		return lr;
	}

	public void add(Role role) {
		em.persist(role);

	}
	
	public void drop()
	{
		em.createQuery("Delete From Role").executeUpdate();
	}
}