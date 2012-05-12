package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.SaleDAO;
import daxzel.model.domains.Organization;
import daxzel.model.domains.Production;
import daxzel.model.domains.Role;
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
        sale.setProduction(em.find(Production.class, sale.getProductionKey()));
        em.close();
        return sale;
    }

    public List<Sale> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Sale> lr = em.createQuery("Select From Sale").getResultList();
        for(Sale sale : lr)
        {
            sale.setOrganization(em.find(Organization.class,sale.getOrganizationKey()));
            sale.setProduction(em.find(Production.class, sale.getProductionKey()));
        }
        em.close();
        return lr;
    }

    public void addOrUpdate(Sale sale) {
        EntityManager em = emf.createEntityManager();
        em.persist(sale);
        em.close();
    }

}
