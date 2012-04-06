package daxzel.model.services;

import java.util.List;

import daxzel.model.domains.Product;
import daxzel.model.domains.Group;

public interface ProductService extends AbstractService<Product> {
	Product findProductByNCP(Long NCP);
	Group findGroup(Long key);
	void removeProductByNCP(Long NCP);
	List<Group> getAllGroups();
}
