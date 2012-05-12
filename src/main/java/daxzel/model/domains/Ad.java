package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 1:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Ad {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private Date dateBegin;

    private Date dateEnd;

    private String paymentMethod;

    private int amount;

    private Date paymentDate;

    @ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(nullable=false)
    private KindAd kindAd;

    @Transient
    private Product product;

    private Key keyToProduct;

    private Key keyToGroup;


    public Key getKey()
    {
        return key;
    }

    public Key getKeyToProduct()
    {
        return keyToProduct;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }


    public Product getProduct() {
        return product;
    }

    public Key getKeyToGroup() {
        return keyToGroup;
    }

    public void setKeyToGroup(Key keyToGroup) {
        this.keyToGroup = keyToGroup;
    }

    public void setProduct(Product product) {
        if (product!=null)
        {
            this.keyToProduct = product.getKey();
            this.keyToGroup  = product.getGroup().getKey();
            this.product = product;
        }
        else
        {
            this.keyToProduct = null;
            this.keyToGroup = null;

            this.product = null;
        }
    }

    public KindAd getKindAd() {
        return kindAd;
    }

    public void setKindAd(KindAd kindAd) {
        this.kindAd = kindAd;
    }

}
