package daxzel.model.DAO.impl;

import daxzel.model.DAO.UserDAO;

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

import daxzel.model.domains.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	public void remove(Long id) {
		User user = getByID(id);
		if (user != null) {
			em.remove(user);	
		}
	}

	public User getByID(Long id) {
		return em.find(User.class, id);
	}

	public List<User> getAll() {
		
		List<User> us = em.createQuery("Select From User").getResultList();
		us.size();
		return us;
	}

	public void add(User user) {
		em.persist(user);

	}

	public User getUserByName(String name) {
		User user = (User) em.createQuery(
				"Select u From User u Where u.name='" + name + "'")
				.getSingleResult();
		return user;
	}
}
