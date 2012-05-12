package daxzel.model.DAO.impl;


import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.ProductDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.Group;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager em;

	public void remove(Long id) {
		Product product = getByID(id);
		if (product != null) {
            Group group = product.getGroup();
            group.getProductKeys().remove(product.getKey());
            em.remove(product);
            em.merge(group);
		}
	}


	public Product getByID(Long id) {
		return em.find(Product.class, id);
	}


	public List<Product> getAll() {
		
		List<Product> lr = em.createQuery("Select From Product").getResultList();
		lr.size();
		return lr;
	}

	public void addOrUpdate(Product product) {
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

	}
	
	public Product findProductByNCP(Long NCP)
	{
		return (Product)em.createQuery("Select p From Product p Where p.NCP="+NCP).getSingleResult();
	}

	public void removeProductByNCP(Long NCP)
	{
		em.createQuery("Delete From Product p Where p.NCP="+NCP).executeUpdate();
	}

    public Product getProductByName(String name)
    {
        Product product = (Product) em.createQuery(
                "Select From Product Where name='" + name + "'")
                .getSingleResult();
        return product;
    }

	
	
}