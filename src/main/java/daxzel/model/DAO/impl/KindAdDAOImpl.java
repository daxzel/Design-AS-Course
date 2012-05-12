package daxzel.model.DAO.impl;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import daxzel.model.DAO.KindAdDAO;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.Group;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.KindAd;

@Repository
public class KindAdDAOImpl implements KindAdDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
        KindAd kindAd = getByID(id);
        if (kindAd != null) {
            em.remove(kindAd);
          
        }
        em.close();
    }

    public KindAd getByID(Long id) {
        EntityManager em = emf.createEntityManager();
        KindAd kindAd =  em.find(KindAd.class, KeyFactory.createKey(KindAd.class.getSimpleName(), id));
        em.close();
        return kindAd;
    }

    public List<KindAd> getAll() {
        EntityManager em = emf.createEntityManager();
        List<KindAd> lr = em.createQuery("Select From KindAd").getResultList();
        lr.size();
        em.close();
        return lr;
    }

    public void addOrUpdate(KindAd kindAd) {
        EntityManager em = emf.createEntityManager();
        em.persist(kindAd);
        em.close();

    }

    public KindAd getKindAdByName(String name){
        EntityManager em = emf.createEntityManager();
        KindAd kind = (KindAd) em.createQuery(
                "Select From KindAd Where name='" + name + "'")
                .getSingleResult();
        em.close();
        return kind;
    }

	
	
}