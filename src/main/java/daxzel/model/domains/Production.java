package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.omg.CORBA.LongHolder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @NotNull(message="Введите количество товаров")
    @Min(value = 0, message ="Количество товаров должно быть больше 0")
    private int count;

    @Size(min=6, max=50, message="Единица измерения должна быть от 1 до 10 символов")
    private String unitOfMeasurement;

    @NotNull(message="Введите затраты на производство")
    @Min(value = 0, message ="Затраты на производство должны быть больше 0")
    private int costsProduction;

    @NotNull(message="Введите затраты на хранение")
    @Min(value = 0, message ="Затраты на хранение должны быть больше 0")
    private int costsStorage;

    private boolean sold = false;

    @Transient
    private Product product;

    @Basic(fetch = FetchType.EAGER)
    @NotNull(message="Должен быть указан произведённый товар")
    private Long productKey;


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


    public Long getProductKey() {
        return productKey;
    }

    public void setProductKey(Long productKey) {
        this.productKey = productKey;
    }




    public Product getProduct() {
        return product;
    }

    public Long getKey()
    {
        return key;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
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
