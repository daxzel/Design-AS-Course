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
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        Ad ad = getByID(id);
        if (ad != null) {
            Product product = ad.getProduct();
            product.getAdsKeys().remove(ad.getKey());
            em.persist(product);
            em.remove(ad);
        }
    }

    public Ad getByID(Long id) {

        Key keyAd = KeyFactory.createKey(Ad.class.getSimpleName(), id);
        Ad ad =  em.find(Ad.class, keyAd);

        Key keyGroup = KeyFactory.createKey(Group.class.getSimpleName(), ad.getKeyToGroup());
        Key keyProduct = KeyFactory.createKey(keyGroup,Product.class.getSimpleName(), ad.getKeyToProduct());
        ad.setProduct(em.find(Product.class, keyProduct));
        return  ad;
    }

    public List<Ad> getAll() {

        return null;
    }

    @Transactional
    public  List<Ad>  getAds()
    {
        List<Ad> lr = em.createQuery("Select From Ad").getResultList();
        for(Ad ad : lr)
        {
            ad.getKindAd().getName();
        }
        return lr;
    }

    @Transactional
    public void fillAdsProducts(List<Ad> lr)
    {
        for(Ad ad : lr)
        {
            Key keyGroup = KeyFactory.createKey(Group.class.getSimpleName(), ad.getKeyToGroup());

            Key keyProduct = KeyFactory.createKey(keyGroup, Product.class.getSimpleName(), ad.getKeyToProduct());

            ad.setProduct(em.find(Product.class, keyProduct));
        }
    }

    @Transactional
    private  void addAd(Ad ad)
    {
        em.persist(ad);
    }
    
    
    public void addOrUpdate(Ad ad) {
        addAd(ad);
        addToProduct(ad);
    }

    @Transactional
    private void addToProduct(Ad ad)
    {
        Product product = ad.getProduct();

        List<Long> keys = product.getAdsKeys();
        if (keys == null)
        {
            keys = new ArrayList<Long>();
        }
        keys.add(ad.getKey());
        product.setAdsKeys(keys);
        em.merge(product);
    }
    
}
