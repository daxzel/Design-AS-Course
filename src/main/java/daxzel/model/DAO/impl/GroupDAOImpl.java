package daxzel.model.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import daxzel.model.domains.Product;
import org.springframework.stereotype.Repository;

import daxzel.model.DAO.GroupDAO;
import daxzel.model.domains.Group;

@Repository
public class GroupDAOImpl implements GroupDAO {


    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

	public void remove(Long id) {
        EntityManager em = emf.createEntityManager();

		Group group = getByID(id) ;
		if (group != null) {
			em.remove(group);	
		}

        em.close();
	}

    public Group getByID(Long id) {
        EntityManager em = emf.createEntityManager();
        Group group =  em.find(Group.class, KeyFactory.createKey(Group.class.getSimpleName(), id));
        em.close();
        return group;
    }

	public List<Group> getAll() {
        EntityManager em = emf.createEntityManager();

		List<Group> lr = em.createQuery("Select From Group").getResultList();
		
		for(Group group : lr)
		{
            List<Product> products = new ArrayList<Product>();

            for(Long key : group.getProductKeys())
            {
                em.getTransaction().begin();
                products.add(em.find(Product.class,key));
                em.getTransaction().commit();
            }

            group.setProducts(products);
		}

        em.close();
        
        
		return lr;
	}

	public void addOrUpdate(Group group) {
        EntityManager em = emf.createEntityManager();
		em.persist(group);
        em.close();


	}	
}