package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.OrderDAO;
import daxzel.model.domains.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        Order order = getByID(id);
        if (order != null) {
            em.remove(order);
        }
    }

    public Order getByID(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> getAll() {

        List<Order> lr = em.createQuery("Select From Order").getResultList();
        lr.size();
        return lr;
    }

    public void addOrUpdate(Order order) {
        em.persist(order);

    }


}
