package daxzel.model.services.ReportHelpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/19/12
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonthsCostsPrices {

    List<MonthCostPrice> monthCostPriceList = new ArrayList<MonthCostPrice>();


    public List<MonthCostPrice> getMonthCostPriceList() {
        return monthCostPriceList;
    }

    public void setMonthCostPriceList(List<MonthCostPrice> monthCostPriceList) {
        this.monthCostPriceList = monthCostPriceList;
    }
}
