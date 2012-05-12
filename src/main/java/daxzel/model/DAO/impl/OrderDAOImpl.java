package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.OrderDAO;
import daxzel.model.domains.Order;
import daxzel.model.domains.Organization;
import daxzel.model.domains.Production;
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
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
        Order order = getByID(id);
        if (order != null) {
            em.remove(order);
        }
        em.close();
    }

    public Order getByID(Long id) {
        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, id);
        order.setOrganization(em.find(Organization.class,order.getOrganizationKey()));
        order.setProduction(em.find(Production.class, order.getProductionKey()));
        em.close();
        return order;
    }

    public List<Order> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Order> lr = em.createQuery("Select From Order").getResultList();
        for(Order order : lr)
        {
            order.setOrganization(em.find(Organization.class,order.getOrganizationKey()));
            order.setProduction(em.find(Production.class, order.getProductionKey()));
        }
        return lr;
    }

    public void addOrUpdate(Order order) {
        EntityManager em = emf.createEntityManager();
        em.persist(order);
        em.close();

    }


}
