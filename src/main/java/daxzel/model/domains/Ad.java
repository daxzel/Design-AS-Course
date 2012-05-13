package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @NotNull(message="Введите дату начала рекламы")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateBegin =  new Date(System.currentTimeMillis());

    @NotNull(message="Введите дату окончания рекламы")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateEnd = new Date(System.currentTimeMillis());

    private String paymentMethod;

    @Min(value = 0, message ="Сумма рекламы должна быть больше 0")
    private int amount;

    @NotNull(message="Введите дату оплаты рекламы")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date paymentDate = new Date(System.currentTimeMillis());

    @Transient
    private Product product;

    private Long keyToProduct;

    @Transient
    private KindAd kindAd;

    @Transient
    private Organization organization;

    @Basic(fetch = FetchType.EAGER)
    private Long organizationKey;

    public Long getKeyToKindAd() {
        return keyToKindAd;
    }

    public void setKeyToKindAd(Long keyToKindAd) {
        this.keyToKindAd = keyToKindAd;
    }

    private Long keyToKindAd;


    public Long getKey()
    {
        return key;
    }

    public Long getKeyToProduct()
    {
        return keyToProduct;
    }

    public void setKey(Long key) {
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

    public void setProduct(Product product) {
        if (product!=null)
        {
            this.keyToProduct = product.getKey();
            this.product = product;
        }
        else
        {
            this.keyToProduct = null;
            this.product = null;
        }
    }

    public KindAd getKindAd() {
        return kindAd;
    }

    public void setKindAd(KindAd kindAd) {
        if (kindAd!=null)
        {
            this.keyToKindAd = kindAd.getKey();
            this.kindAd = kindAd;
        }
        else
        {
            this.keyToKindAd = null;
            this.kindAd = null;
        }
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        if (organization!=null)
        {
            this.organization = organization;
            this.organizationKey = organization.getKey();
        }
        else
        {
            this.organizationKey = null;
            this.organization = null;
        }
    }

    public Long getOrganizationKey() {
        return organizationKey;
    }

    public void setOrganizationKey(Long organizationKey) {
        this.organizationKey = organizationKey;
    }

}
