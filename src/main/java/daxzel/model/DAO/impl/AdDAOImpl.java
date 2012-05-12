package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import daxzel.model.DAO.AdDAO;
import daxzel.model.domains.Ad;
import daxzel.model.domains.Group;
import daxzel.model.domains.KindAd;
import daxzel.model.domains.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AdDAOImpl implements AdDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();

        Ad ad = getByID(id);
        if (ad != null) {
            Product product = ad.getProduct();
            product.getAdsKeys().remove(ad.getKey());
            em.persist(product);
            em.remove(ad);
        }
        em.close();
    }

    public Ad getByID(Long id) {
        EntityManager em = emf.createEntityManager();

        Key keyAd = KeyFactory.createKey(Ad.class.getSimpleName(), id);
        Ad ad =  em.find(Ad.class, keyAd);
        ad.setProduct(em.find(Product.class, ad.getKeyToProduct()));
        ad.setKindAd(em.find(KindAd.class, ad.getKeyToKindAd()));
        em.close();
        return  ad;
    }

    public List<Ad> getAll() {
        EntityManager em = emf.createEntityManager();

        List<Ad> lr = em.createQuery("Select From Ad").getResultList();
        for(Ad ad : lr)
        {
            ad.getKindAd().getName();
        }
        for(Ad ad : lr)
        {
            ad.setProduct(em.find(Product.class, ad.getKeyToProduct()));
            ad.setKindAd(em.find(KindAd.class, ad.getKeyToKindAd()));
        }
        em.close();
        return lr;
    }

    public void addOrUpdate(Ad ad) {
        EntityManager em = emf.createEntityManager();

        em.persist(ad);

        Product product = ad.getProduct();

        List<Long> keys = product.getAdsKeys();
        if (keys == null)
        {
            keys = new ArrayList<Long>();
        }
        keys.add(ad.getKey());
        product.setAdsKeys(keys);
        em.merge(product);

        em.close();
    }


}
