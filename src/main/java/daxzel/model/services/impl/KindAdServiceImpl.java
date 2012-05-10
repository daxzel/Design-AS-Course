package daxzel.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daxzel.model.DAO.KindAdDAO;
import daxzel.model.domains.KindAd;
import daxzel.model.services.KindAdService;

@Service 
@Transactional
public class KindAdServiceImpl implements KindAdService {
	
	@Autowired
	private KindAdDAO kindAdDAO;

	@Transactional
	public void add(KindAd entity)
	{
		kindAdDAO.addOrUpdate(entity);
	}

	@Transactional
	public List<KindAd> getAll()
    {
		return kindAdDAO.getAll();
    }

	@Transactional
	public KindAd getByID(Long id)
    {
		return kindAdDAO.getByID(id);
    }
	
	@Transactional
	public void remove(Long id)
    {
		kindAdDAO.remove(id);
    }

    @Transactional
    public KindAd getKindAdByName(String name)
    {
        return kindAdDAO.getKindAdByName(name);
    }
}
