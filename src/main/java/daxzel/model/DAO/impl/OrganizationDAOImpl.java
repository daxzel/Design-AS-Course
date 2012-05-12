package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.OrganizationDAO;
import daxzel.model.domains.KindAd;
import daxzel.model.domains.Organization;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: daxzel
 * Date: 4/9/12
 * Time: 8:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    @PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        Organization organization = getByID(id);
        if (organization != null) {
            em.remove(organization);
        }
    }


    public Organization getByID(Long id) {
        return em.find(Organization.class, id);
    }

    public List<Organization> getAll() {

        List<Organization> lr = em.createQuery("Select From Organization").getResultList();
        lr.size();
        return lr;
    }

    public void addOrUpdate(Organization organization) {
        em.persist(organization);

    }


}