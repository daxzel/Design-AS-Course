package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Order {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    private int price;

    private int transportationCosts;

    private int otherCosts;

    private String idShop;

    private Date dateBegin;

    private int amount;

    private Date datePayment;

    @Transient
    private Production production;

    private Long productionKey;

    @Transient
    private Organization organization;

    public void setOrganizationKey(Long organizationKey) {
        this.organizationKey = organizationKey;
    }

    private Long organizationKey;


    public Long getKey()
    {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTransportationCosts() {
        return transportationCosts;
    }

    public void setTransportationCosts(int transportationCosts) {
        this.transportationCosts = transportationCosts;
    }

    public int getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(int otherCosts) {
        this.otherCosts = otherCosts;
    }

    public String getIdShop() {
        return idShop;
    }

    public void setIdShop(String idShop) {
        this.idShop = idShop;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        if (production!=null)
        {
            this.productionKey = production.getKey();
            this.production = production;
        }
        else
        {
            this.productionKey = null;
            this.production = null;
        }
    }

    public Long getProductionKey() {
        return productionKey;
    }

    public void setProductionKey(Long productionKey) {
        this.productionKey = productionKey;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        if (organization!=null)
        {
            this.organizationKey = organization.getKey();
            this.organization = organization;
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


}
