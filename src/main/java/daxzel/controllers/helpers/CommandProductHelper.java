package daxzel.controllers.helpers;

import daxzel.model.domains.Product;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandProductHelper {
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;
}
