package daxzel.model.services;

import daxzel.model.domains.Product;
import daxzel.model.services.ReportHelpers.ShareAdCosts;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReportService {

    ShareAdCosts GetShareAdCosts(Product product,Date begin,Date end);

}
