package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.omg.CORBA.LongHolder;

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
    private Long key;

    private int count;

    private String unitOfMeasurement;

    private int costsProduction;

    private int costsStorage;

    public void setProduct(Product product) {
        if (product!=null)
        {
            this.productKey = product.getKey();
            this.product = product;
        }
        else
        {
            this.productKey = null;
            this.product = null;
        }
    }

    @Transient
    private Product product;

    public Long getProductKey() {
        return productKey;
    }

    public void setProductKey(Long productKey) {
        this.productKey = productKey;
    }

    @Basic(fetch = FetchType.EAGER)
    private Long productKey;


    public Product getProduct() {
        return product;
    }

    public Long getKey()
    {
        return key;
    }

    public void setKey(Long key) {
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

}
