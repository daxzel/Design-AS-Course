package daxzel.model.DAO;

import daxzel.model.domains.Product;

public interface ProductDAO extends AbstractDAO<Product>  {
	Product findProductByNCP(Long NCP);
	void removeProductByNCP(Long NCP);
    Product getProductByName(String name);
}

