package daxzel.model.DAO.impl;


import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.ProductDAO;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.Group;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

	public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
		Product product = getByID(id);
		if (product != null) {
            Group group = product.getGroup();
            group.getProductKeys().remove(product.getKey());
            em.remove(product);
            em.merge(group);
		}
        em.close();
	}


	public Product getByID(Long id) {
        EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, id);
        em.close();
        return product;
	}


	public List<Product> getAll() {
        EntityManager em = emf.createEntityManager();
               
		List<Product> lr = em.createQuery("Select From Product").getResultList();
		lr.size();
        em.close();
		return lr;
	}

	public void addOrUpdate(Product product) {
        EntityManager em = emf.createEntityManager();
        if (product.getKey()==null)
        {
		    em.persist(product);
            if (product.getGroup()!=null)
            {
                Group group = product.getGroup();
                List<Long> keys = group.getProductKeys();
                if (keys==null)
                {
                    keys = new ArrayList<Long>();    
                }
                keys.add(product.getKey());
                group.setProductKeys(keys);
                em.merge(group);
            }
        }
        else
        {
            
        }
        em.close();

	}
	
	public Product findProductByNCP(Long NCP)
	{
        EntityManager em = emf.createEntityManager();
		Product product = (Product)em.createQuery("Select p From Product p Where p.NCP="+NCP).getSingleResult();
        em.close();
        return product;
	}

	public void removeProductByNCP(Long NCP)
	{
        EntityManager em = emf.createEntityManager();
		em.createQuery("Delete From Product p Where p.NCP="+NCP).executeUpdate();
        em.close();
	}

    public Product getProductByName(String name)
    {
        EntityManager em = emf.createEntityManager();
        Product product = (Product) em.createQuery(
                "Select From Product Where name='" + name + "'")
                .getSingleResult();
        em.close();
        return product;
    }

	
	
}