package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/9/12
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Production {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private int count;

    private String unitOfMeasurement;

    private int costsProduction;

    private int costsStorage;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    private Product product;

    @OneToOne(mappedBy = "production")
    private Sale sale;

    @OneToOne(mappedBy = "production")
    private Order order;


    public Long getKey()
    {
        if (key!=null)
        {
            return key.getId();
        }
        else
        {
            return null;
        }
    }

    public void setKey(Long id)
    {
        key = KeyFactory.createKey(Product.class.getSimpleName(), id);
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getCostsProduction() {
        return costsProduction;
    }

    public void setCostsProduction(int costsProduction) {
        this.costsProduction = costsProduction;
    }

    public int getCostsStorage() {
        return costsStorage;
    }

    public void setCostsStorage(int costsStorage) {
        this.costsStorage = costsStorage;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



}
