package daxzel.model.services.impl;

import daxzel.model.domains.*;
import daxzel.model.services.ReportHelpers.*;
import daxzel.model.services.ReportService;
import org.springframework.stereotype.Service;

import java.awt.event.AdjustmentListener;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ReportServiceImpl implements ReportService {



    public ShareAdCosts getShareAdCosts(Product product,Date begin,Date end){

        long allCosts = 0;

        ShareAdCosts shareAdCosts = new ShareAdCosts();

        List<Ad> adList = product.getAds();


        Map<Organization,Long> organizationCosts = new HashMap<Organization, Long>();
        for(Ad ad : adList){
            Organization organization = ad.getOrganization();

            long cost = 0;

            if (organizationCosts.containsKey(organization))
            {
                cost = organizationCosts.get(organization);
            }
            cost+=ad.getAmount();
            organizationCosts.put(organization,cost);
            allCosts+=ad.getAmount();

        }

        HashMap<KindAd,Long> kindAdCosts = new HashMap<KindAd, Long>();

        for(Ad ad : adList){
            KindAd kindAd = ad.getKindAd();

            long cost = 0;

            if (kindAdCosts.containsKey(kindAd))
            {
                cost = kindAdCosts.get(kindAd);
            }
            cost+=ad.getAmount();
            kindAdCosts.put(kindAd,cost);
        }

        for (Organization organization : organizationCosts.keySet())
        {
            Long cost = organizationCosts.get(organization);

            long shareCost = Math.round((((double) cost) / ((double) allCosts) * 100.0));

            shareAdCosts.getOrganizationAndShareCostList().add(new OrganizationAndShareCost(organization,shareCost));

        }

        for (KindAd kindAd : kindAdCosts.keySet())
        {
            Long cost = kindAdCosts.get(kindAd);

            long shareCost = Math.round((((double) cost) / ((double) allCosts) * 100.0));

            shareAdCosts.getKindAdAndShareCostList().add(new KindAdAndShareCost(kindAd,shareCost));

        }

        return shareAdCosts;

    }

    public MonthsAmountsMargins getMonthsAmountsMargins(Product product)
    {
        List<Sale> sales = product.getSales();

        List<Ad> ads = product.getAds();

        Calendar cal = Calendar.getInstance();

        HashMap<String,SaleAndAd> mountSaleAd = new HashMap<String, SaleAndAd>();

        for(Sale sale : sales)
        {
            cal.setTime(sale.getDateBegin());

            String month =Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.MONTH));

            if (mountSaleAd.containsKey(month))
            {
                mountSaleAd.get(month).getSales().add(sale);
            }

            mountSaleAd.put(month, new SaleAndAd());

        }

        for(Ad ad : ads)
        {
            cal.setTime(ad.getDateBegin());

            String month =Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.MONTH));

            if (mountSaleAd.containsKey(month))
            {
                mountSaleAd.get(month).getAds().add(ad);
            }

            mountSaleAd.put(month, new SaleAndAd());

        }

        MonthsAmountsMargins result = new MonthsAmountsMargins();


        for(String month : mountSaleAd.keySet())
        {
            SaleAndAd saleAndAd = mountSaleAd.get(month);

            int adCost = 0;

            for(Ad ad : saleAndAd.getAds())
            {
                adCost+=ad.getAmount();
            }

            int margin = 0;

            int count = 0;

            for(Sale sale : saleAndAd.getSales())
            {
                count+= sale.getProduction().getCount();
                margin+=sale.getAmount();
            }

            result.getResult().add(new MonthAmountMargin(margin,count,month,adCost));

        }

        return result;
    }

    class SaleAndAd{

        private List<Sale> sales = new ArrayList<Sale>();

        private List<Ad> ads = new ArrayList<Ad>();

        public List<Sale> getSales() {
            return sales;
        }

        public void setSales(List<Sale> sales) {
            this.sales = sales;
        }

        public List<Ad> getAds() {
            return ads;
        }

        public void setAds(List<Ad> ads) {
            this.ads = ads;
        }
    }


}
