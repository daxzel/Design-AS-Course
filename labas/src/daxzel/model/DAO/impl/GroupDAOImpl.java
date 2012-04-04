package daxzel.model.DAO.impl;


import daxzel.model.DAO.GroupDAO;
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
		lr.size();
		return lr;
	}

	public void addOrUpdate(Group group) {
		em.persist(group);

	}
	
	public Group findGroupByNCP(Long NCP)
	{
		return (Group)em.createQuery("Select g From Group g Where g.NCP="+NCP).getSingleResult();
	}

	public void removeGroupByNCP(Long NCP)
	{
		em.createQuery("Delete From Group g Where g.NCP="+NCP).executeUpdate();
	}
	
	
}