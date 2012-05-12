package daxzel.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import daxzel.model.domains.Product;
import daxzel.model.domains.Group;
import daxzel.model.services.ProductService;
import daxzel.model.DAO.ProductDAO;
import daxzel.model.DAO.GroupDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private GroupDAO groupDAO;

	public void add(Product entity) {
		if (entity.getGroup() == null) {
			Group group = new Group();
			entity.setGroup(group);
		}
		productDAO.addOrUpdate(entity);
	}

	public List<Product> getAll() {
		return productDAO.getAll();
	}

	public Product getByID(Long id) {
		return productDAO.getByID(id);
	}

	public void remove(Long id) {
		Product product = productDAO.getByID(id);
		if (product != null) {
			Group group = product.getGroup();
			if (group.getProducts().size() == 1) {
				groupDAO.remove(group.getKey());
			} else {
				productDAO.remove(id);
			}
		}
	}

	public Product findProductByNCP(Long NCP) {
		return productDAO.findProductByNCP(NCP);
	}

	public void removeProductByNCP(Long NCP) {
		Product product = productDAO.findProductByNCP(NCP);
		if (product != null) {
			Group group = product.getGroup();
			if (group.getProducts().size() == 1) {
				groupDAO.remove(group.getKey());
			} else {
				productDAO.removeProductByNCP(NCP);
			}
		}
	}

	public List<Group> getAllGroups() {
		return groupDAO.getAll();
	}

	public Group findGroup(Long key)
	{
		return groupDAO.getByID(key);
	}

    public Product getProductByName(String name)
    {
        return productDAO.getProductByName(name);
    }

}