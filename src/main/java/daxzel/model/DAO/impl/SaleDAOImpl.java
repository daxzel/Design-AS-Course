package daxzel.model.DAO.impl;

import daxzel.model.DAO.SaleDAO;
import daxzel.model.domains.Role;
import daxzel.model.domains.Sale;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        Sale sale = getByID(id);
        if (sale != null) {
            em.remove(sale);
        }
    }

    public Sale getByID(Long id) {
        return em.find(Sale.class, id);
    }

    public List<Sale> getAll() {
        List<Sale> lr = em.createQuery("Select From Sale").getResultList();
        lr.size();
        return lr;
    }

    public void addOrUpdate(Sale sale) {
        em.persist(sale);

    }

}
