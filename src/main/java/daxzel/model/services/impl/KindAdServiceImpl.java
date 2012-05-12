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

	public void add(KindAd entity)
	{
		kindAdDAO.addOrUpdate(entity);
	}

	public List<KindAd> getAll()
    {
		return kindAdDAO.getAll();
    }

	public KindAd getByID(Long id)
    {
		return kindAdDAO.getByID(id);
    }

	public void remove(Long id)
    {
		kindAdDAO.remove(id);
    }

    public KindAd getKindAdByName(String name)
    {
        return kindAdDAO.getKindAdByName(name);
    }
}
