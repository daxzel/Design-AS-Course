package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.SaleDAO;
import daxzel.model.domains.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SaleDAOImpl implements SaleDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
        Sale sale = getByID(id);
        if (sale != null) {
            em.remove(sale);
        }
        em.close();
    }

    public Sale getByID(Long id) {
        EntityManager em = emf.createEntityManager();
        Sale sale = em.find(Sale.class, id);
        sale.setOrganization(em.find(Organization.class,sale.getOrganizationKey()));
        Production production = em.find(Production.class, sale.getProductionKey());
        production.setProduct(em.find(Product.class, production.getProductKey()));
        sale.setProduction(production);
        em.close();
        return sale;
    }

    public List<Sale> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Sale> lr = em.createQuery("Select From Sale").getResultList();
        for(Sale sale : lr)
        {
            sale.setOrganization(em.find(Organization.class,sale.getOrganizationKey()));
            Production production = em.find(Production.class, sale.getProductionKey());
            production.setProduct(em.find(Product.class, production.getProductKey()));
            sale.setProduction(production);
        }
        em.close();
        return lr;
    }

    public void addOrUpdate(Sale sale) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(sale);
        em.getTransaction().commit();


        Product product = sale.getProduction().getProduct();

        List<Long> keys = product.getKeysSales();
        if (keys == null)
        {
            keys = new ArrayList<Long>();
        }
        keys.add(sale.getKey());
        product.setKeysSales(keys);
        em.merge(product);


        em.close();




    }

}
