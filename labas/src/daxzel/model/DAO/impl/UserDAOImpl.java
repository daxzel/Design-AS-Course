package daxzel.model.DAO.impl;

import daxzel.model.DAO.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import daxzel.utils.EMF;
import daxzel.model.domains.User;

@Repository
public class UserDAOImpl implements UserDAO {
	 
	public void remove(Long id)
	{
	    
	}
	
	public User getByID(Long id)
	{
		EntityManager em = EMF.get().createEntityManager();
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
		EntityManager em = EMF.get().createEntityManager();
		List<User> ul=null;
		try
		{
			Query q = em.createQuery("Select From User");
			
			ul = q.getResultList();
		}
		finally
		{
			em.close();
		}
		
		return ul;
	}
	
	public void add(User user)
	{
		EntityManager em = EMF.get().createEntityManager();
		try
		{
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			
			em.persist(user);
			
			et.commit();
		}
		finally
		{
			em.close();
		}
	}
}
