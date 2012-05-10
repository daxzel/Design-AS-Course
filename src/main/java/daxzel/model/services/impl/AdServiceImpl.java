package daxzel.model.services.impl;

import daxzel.model.DAO.AdDAO;
import daxzel.model.domains.Ad;
import daxzel.model.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AdServiceImpl  implements AdService {

    @Autowired
    private AdDAO adDAO;

    @Transactional
    public void add(Ad entity)
    {
        adDAO.addOrUpdate(entity);
    }

    @Transactional
    public List<Ad> getAll()
    {
        return adDAO.getAll();
    }

    @Transactional
    public Ad getByID(Long id)
    {
        return adDAO.getByID(id);
    }

    @Transactional
    public void remove(Long id)
    {
        adDAO.remove(id);
    }
}
