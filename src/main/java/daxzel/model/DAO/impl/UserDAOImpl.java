package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.UserDAO;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.Role;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.User;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

	public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, id);
		if (user != null) {
			em.remove(user);
		}
        em.close();
	}

	public User getByID(Long id) {
        EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, id);
        loadRole(user,em);
        em.close();
        return user;
	}

	public List<User> getAll() {
        EntityManager em = emf.createEntityManager();
		List<User> us = em.createQuery("Select From User").getResultList();
		us.size();
        em.close();
		return us;
	}

	public void addOrUpdate(User user) {
        EntityManager em = emf.createEntityManager();
		if (user.getKey()==null)
		{
            em.persist(user);
		}
        else{
            User userx = em.find(User.class, user.getKey());
            if (userx != null) {
                userx.setName(user.getName());
                userx.setPassword(user.getPassword());
            } else {
                em.persist(user);
            }
        }
        em.close();

	}

    private void loadRole(User user, EntityManager em)
    {
        Role role = em.find(Role.class,user.getKeyToRole());
        user.setRole(role);
    }        

	public User getUserByName(String name) {
        EntityManager em = emf.createEntityManager();
		User user = (User) em.createQuery(
				"Select u From User u Where u.name='" + name + "'")
				.getSingleResult();
        loadRole(user,em);
        em.close();
		return user;
	}
}
