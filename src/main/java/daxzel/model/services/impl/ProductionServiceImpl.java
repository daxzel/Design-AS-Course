package daxzel.model.services.impl;

import daxzel.model.DAO.ProductionDAO;
import daxzel.model.domains.Production;
import daxzel.model.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDAO productionDAO;

    @Transactional
    public void add(Production entity)
    {
        productionDAO.addOrUpdate(entity);
    }

    @Transactional
    public List<Production> getAll()
    {
        return productionDAO.getAll();
    }

    @Transactional
    public Production getByID(Long id)
    {
        return productionDAO.getByID(id);
    }

    @Transactional
    public void remove(Long id)
    {
        productionDAO.remove(id);
    }

}
