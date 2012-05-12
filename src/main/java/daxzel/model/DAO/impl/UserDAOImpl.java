package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	public void remove(Long id) {
		User user = em.find(User.class, id);
		if (user != null) {
			em.remove(user);
		}
	}

	public User getByID(Long id) {
		User user = em.find(User.class, id);
        loadRole(user);
        return user;
	}

	public List<User> getAll() {

		List<User> us = em.createQuery("Select From User").getResultList();
		us.size();
		return us;
	}

	public void addOrUpdate(User user) {
		if (user.getKey()==null)
		{
            em.persist(user);


			return;
		}
		User userx = em.find(User.class, user.getKey());
		if (userx != null) {
			userx.setName(user.getName());
			userx.setPassword(user.getPassword());
		} else {
			em.persist(user);
		}

	}

    private void loadRole(User user)
    {
        Role role = em.find(Role.class,user.getKeyToRole());
        user.setRole(role);
    }        

	public User getUserByName(String name) {
		User user = (User) em.createQuery(
				"Select u From User u Where u.name='" + name + "'")
				.getSingleResult();
        loadRole(user);
		return user;
	}
}
