package daxzel.model.DAO.impl;

import daxzel.model.DAO.AdDAO;
import daxzel.model.domains.Ad;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AdDAOImpl implements AdDAO {

    @PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        Ad ad = getByID(id);
        if (ad != null) {
            em.remove(ad);
        }
    }

    public Ad getByID(Long id) {
        return em.find(Ad.class, id);
    }

    public List<Ad> getAll() {
        List<Ad> lr = em.createQuery("Select From Ad").getResultList();


        for(Ad ad : lr)
        {
            ad.getProduct().getName();
            ad.getKindAd().getName();
        }
        return lr;
    }

    public void addOrUpdate(Ad ad) {
        em.persist(ad);

    }
}
