package daxzel.model.services.ReportHelpers;

import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonthAmountMargin {

    int margin;

    int amount;

    String month;

    int adCost;

    public MonthAmountMargin(int margin, int amount, String month, int adCost) {
        this.margin = margin;
        this.amount = amount;
        this.month = month;
        this.adCost = adCost;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAdCost() {
        return adCost;
    }

    public void setAdCost(int adCost) {
        this.adCost = adCost;
    }

}
