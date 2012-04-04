package daxzel.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daxzel.model.DAO.ProductDAO;
import daxzel.model.domains.Product;
import daxzel.model.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	public void add(Product entity)
	{
		productDAO.addOrUpdate(entity);
	}

	@Transactional
	public List<Product> getAll()
    {
		return productDAO.getAll();
    }

	@Transactional
	public Product getByID(Long id)
    {
		return productDAO.getByID(id);
    }
    	
	@Transactional
	public void remove(Long id)
    {
		productDAO.remove(id);
    }
	
}