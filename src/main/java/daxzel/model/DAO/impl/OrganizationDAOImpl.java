package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.OrganizationDAO;
import daxzel.model.domains.KindAd;
import daxzel.model.domains.Organization;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
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

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
        Organization organization = getByID(id);
        if (organization != null) {
            em.remove(organization);
        }
        em.close();
    }


    public Organization getByID(Long id) {
        EntityManager em = emf.createEntityManager();
        Organization organization =  em.find(Organization.class, id);
        em.close();
        return organization;
    }

    public List<Organization> getAll() {

        EntityManager em = emf.createEntityManager();
        List<Organization> lr = em.createQuery("Select From Organization").getResultList();
        lr.size();
        em.close();
        return lr;
    }

    public void addOrUpdate(Organization organization) {
        EntityManager em = emf.createEntityManager();   
        em.persist(organization);
        em.close();

    }

    public Organization getOrganizationByName(String name){
        EntityManager em = emf.createEntityManager();
        Organization organization = (Organization) em.createQuery(
                "Select From Organization Where name='" + name + "'")
                .getSingleResult();
        em.close();
        return organization;
    }


}