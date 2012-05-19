package daxzel.model.services.ReportHelpers;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/19/12
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductCosts {

    int adCost;

    int storageCost;

    int otherCost;

    int costsProduction;

    int transportationCosts;


    public ProductCosts(int adCost, int storageCost, int otherCost, int costsProduction, int transportationCosts) {
        this.adCost = adCost;
        this.storageCost = storageCost;
        this.otherCost = otherCost;
        this.costsProduction = costsProduction;
        this.transportationCosts = transportationCosts;
    }

    public int getAdCost() {
        return adCost;
    }

    public void setAdCost(int adCost) {
        this.adCost = adCost;
    }

    public int getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(int storageCost) {
        this.storageCost = storageCost;
    }

    public int getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(int otherCost) {
        this.otherCost = otherCost;
    }

    public int getCostsProduction() {
        return costsProduction;
    }

    public void setCostsProduction(int costsProduction) {
        this.costsProduction = costsProduction;
    }

    public int getTransportationCosts() {
        return transportationCosts;
    }

    public void setTransportationCosts(int transportationCosts) {
        this.transportationCosts = transportationCosts;
    }


}
