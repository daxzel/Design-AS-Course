package daxzel.model.services.impl;

import daxzel.model.DAO.SaleDAO;
import daxzel.model.domains.Sale;
import daxzel.model.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;

    public void add(Sale entity)
    {
        saleDAO.addOrUpdate(entity);
    }

    public List<Sale> getAll()
    {
        return saleDAO.getAll();
    }

    public Sale getByID(Long id)
    {
        return saleDAO.getByID(id);
    }

    public void remove(Long id)
    {
        saleDAO.remove(id);
    }
}
