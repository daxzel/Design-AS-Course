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
    private Key key;

    private int price;

    private int transportationCosts;

    private int otherCosts;

    private String idShop;

    private Date dateBegin;

    private int amount;

    @OneToOne
    private Production production;

    public Key getKey()
    {
        return key;
    }

    public void setKey(Key key) {
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
        this.production = production;
    }


}
