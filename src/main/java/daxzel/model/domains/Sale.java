package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/9/12
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Sale {
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

    @Transient
    private Production production;

    @Basic(fetch = FetchType.EAGER)
    private Long productionKey;

    @Transient
    private Organization organization;

    @Basic(fetch = FetchType.EAGER)
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

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        if (production!=null)
        {
            this.production = production;
            this.productionKey = production.getKey();
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
