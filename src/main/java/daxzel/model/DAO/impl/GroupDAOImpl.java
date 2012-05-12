package daxzel.model.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.springframework.stereotype.Repository;

import daxzel.model.DAO.GroupDAO;
import daxzel.model.domains.Group;

@Repository
public class GroupDAOImpl implements GroupDAO {

	@PersistenceContext
	private EntityManager em;

	public void remove(Long id) {
		Group group = getByID(id) ;
		if (group != null) {
			em.remove(group);	
		}
	}

    public void remove(Key key) {
        Group group = em.find(Group.class, key);
        if (group != null) {
            em.remove(group);
        }
    }

    public Group getByID(Long id) {
        return  em.find(Group.class, KeyFactory.createKey(Group.class.getSimpleName(), id));
    }

    public Group getByID(Key key) {
        return  em.find(Group.class, key);
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