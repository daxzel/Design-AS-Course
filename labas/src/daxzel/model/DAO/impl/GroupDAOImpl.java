package daxzel.model.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import daxzel.model.DAO.GroupDAO;
import daxzel.model.domains.Group;

@Repository
public class GroupDAOImpl implements GroupDAO {

	@PersistenceContext
	private EntityManager em;

	public void remove(Long id) {
		Group group = getByID(id);
		if (group != null) {
			em.remove(group);	
		}
	}

	public Group getByID(Long id) {
		return em.find(Group.class, id);
	}

	public List<Group> getAll() {
		
		List<Group> lr = em.createQuery("Select From Group").getResultList();
		
		for(Group group : lr)
		{
			group.getProducts().size();
		}
		
		return lr;
	}

	public void addOrUpdate(Group group) {
		em.persist(group);

	}	
}