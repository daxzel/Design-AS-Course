package daxzel.model.DAO.impl;

import daxzel.model.DAO.KindAdDAO;
import javax.persistence.EntityManager;
import javax.persistence.criteria.QueryBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Expression;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.ArrayList;
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

	public KindAd getByID(Long id) {
		return em.find(KindAd.class, id);
	}

	public List<KindAd> getAll() {
		
		List<KindAd> lr = em.createQuery("Select From KindAd").getResultList();
		lr.size();
		return lr;
	}

	public void addOrUpdate(KindAd kindAd) {
		em.persist(kindAd);

	}
	
	
}