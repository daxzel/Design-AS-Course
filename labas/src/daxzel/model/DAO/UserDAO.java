package daxzel.model.DAO;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import daxzel.utils.EMF;
import daxzel.model.domains.User;

public class UserDAO {
	
	public static User getByID(Long key)
	{
		EntityManager em = EMF.get().createEntityManager();
		User us=null;
		try
		{
			//Query q = em.createQuery("Select From User Where User.key=" + key.toString());
			Query q = em.createQuery("Select key From User");
			us = (User)q.getSingleResult();
		}
		finally
		{
			em.close();
		}
		
		return us;
	}
	
	public static List<User> getAll()
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
	

}
