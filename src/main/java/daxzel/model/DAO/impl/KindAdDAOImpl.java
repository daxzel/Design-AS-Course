package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import daxzel.model.DAO.KindAdDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.Group;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.KindAd;

@Repository
public class KindAdDAOImpl implements KindAdDAO {

	@PersistenceContext
    private EntityManager em;

    public void remove(Long id) {
        KindAd kindAd = getByID(id);
        if (kindAd != null) {
            em.remove(kindAd);
        }
    }

    public void remove(Key key) {
        KindAd kindAd = getByID(key);
        if (kindAd != null) {
            em.remove(kindAd);
        }
    }

    public KindAd getByID(Long id) {
        return em.find(KindAd.class, KeyFactory.createKey(KindAd.class.getSimpleName(), id));
    }

    public KindAd getByID(Key key) {
        return em.find(KindAd.class, key);
    }

    public List<KindAd> getAll() {

        List<KindAd> lr = em.createQuery("Select From KindAd").getResultList();
        lr.size();
        return lr;
    }

    public void addOrUpdate(KindAd kindAd) {
        em.persist(kindAd);

    }

    public KindAd getKindAdByName(String name){

//        for (KindAd kind : getAll())
//        {
//            if (kind.getName()==name)
//            {
//                return kind;
//            }
//        }
        KindAd kind = (KindAd) em.createQuery(
                "Select From KindAd Where name='" + name + "'")
                .getSingleResult();
        return kind;
//        return null;
    }

	
	
}