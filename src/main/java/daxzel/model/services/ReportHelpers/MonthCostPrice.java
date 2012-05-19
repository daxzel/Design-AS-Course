package daxzel.model.services.ReportHelpers;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/19/12
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonthCostPrice {

    int cost;

    int price;

    String month;

    public MonthCostPrice(int cost, int price, String month) {
        this.cost = cost;
        this.price = price;
        this.month = month;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


}
