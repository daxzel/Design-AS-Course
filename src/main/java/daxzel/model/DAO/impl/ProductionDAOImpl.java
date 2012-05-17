package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.ProductionDAO;
import daxzel.model.domains.Product;
import daxzel.model.domains.Production;
import daxzel.model.domains.Sale;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductionDAOImpl implements ProductionDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
        Production production = getByID(id);
        if (production != null) {
            em.remove(production);
        }
        em.close();
    }

    public Production getByID(Long id) {
        EntityManager em = emf.createEntityManager();
        Production production =  em.find(Production.class, id);
        production.setProduct(em.find(Product.class,production.getProductKey()));
        em.close();
        return production;
    }

    public List<Production> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Production> lr = em.createQuery("Select From Production").getResultList();
        for(Production production : lr)
        {
            production.setProduct(em.find(Product.class,production.getProductKey()));
        }
        em.close();
        return lr;
    }

    public List<Production> getEmptyProduction()
    {
        EntityManager em = emf.createEntityManager();
        List<Production> lr = em.createQuery("Select From Production Where sold = false").getResultList();
        for(Production production : lr)
        {
            production.setProduct(em.find(Product.class,production.getProductKey()));
        }
        em.close();
        return lr;
    }


    public void addOrUpdate(Production production) {
        EntityManager em = emf.createEntityManager();
        em.persist(production);
        em.close();
    }

}
