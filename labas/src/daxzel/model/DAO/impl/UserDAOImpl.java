package daxzel.model.DAO.impl;

import daxzel.model.DAO.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


import daxzel.model.domains.User;

@Repository
public class UserDAOImpl implements UserDAO {
	 
	@PersistenceContext
	private EntityManager em;

	
	public void remove(Long id)
	{
	    
	}
	
	public User getByID(Long id)
	{
		User us=null;
		try
		{
			Query q = em.createQuery("Select From User Where User.key=" + id.toString());
			List<User> ul = q.getResultList();
			if (ul.size()==1)
			{
				us = ul.get(0);
			}
		}
		finally
		{
			em.close();
		}
		
		return us;
	}
	
	public List<User> getAll()
	{
		List<User> us = em.createQuery("Select From User").getResultList();
		us.size();
		return us;
	}
	
	public void add(User user)
	{
			em.persist(user);

	}
	
	public User getUserByName(String name)
	{
		User us=null;
//		try
//		{
//			Query q = em.createQuery("Select From User Where User.name=" + name);
//			List<User> ul = q.getResultList();
//			if (ul.size()==1)
//			{
//				us = ul.get(0);
//			}
//		}
//		finally
//		{
//			em.close();
//		}
		
		return us;
	}
}
