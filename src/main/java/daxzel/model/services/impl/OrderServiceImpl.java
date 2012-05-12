package daxzel.model.services.impl;

import daxzel.model.DAO.OrderDAO;
import daxzel.model.domains.Order;
import daxzel.model.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public void add(Order entity)
    {
        orderDAO.addOrUpdate(entity);
    }

    public List<Order> getAll()
    {
        return orderDAO.getAll();
    }

    public Order getByID(Long id)
    {
        return orderDAO.getByID(id);
    }

    public void remove(Long id)
    {
        orderDAO.remove(id);
    }
}