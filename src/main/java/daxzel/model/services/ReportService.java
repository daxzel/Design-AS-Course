package daxzel.model.services;

import daxzel.model.domains.Product;
import daxzel.model.services.ReportHelpers.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReportService {

    ShareAdCosts getShareAdCosts(Product product,Date begin,Date end);

    MonthsAmountsMargins getMonthsAmountsMargins(Product product);

    ProductCosts getProductCosts(Product product);

    MonthsCostsPrices getMonthsCostPrices(Product product);

}
