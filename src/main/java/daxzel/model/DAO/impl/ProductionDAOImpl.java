package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.ProductionDAO;
import daxzel.model.domains.Production;
import daxzel.model.domains.Sale;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        Production production = getByID(id);
        if (production != null) {
            em.remove(production);
        }
    }

    public Production getByID(Long id) {
        return em.find(Production.class, id);
    }

    public List<Production> getAll() {
        List<Production> lr = em.createQuery("Select From Production").getResultList();
        lr.size();
        return lr;
    }

    public void addOrUpdate(Production production) {
        em.persist(production);

    }

}
