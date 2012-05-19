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

        Calendar cal = Calendar.getInstance();

        HashMap<String,SaleAndAd> mountSaleAd = new HashMap<String, SaleAndAd>();
        List<String> sortMonths = new ArrayList<String>();

        for(Sale sale : product.getSales())
        {
            cal.setTime(sale.getDateBegin());


            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);


            String monthString = Integer.toString(year) + ' ' + Integer.toString(month);


            if (mountSaleAd.containsKey(monthString))
            {
                mountSaleAd.get(monthString).getSales().add(sale);
            }
            else
            {
                int i = 0;
                for (String keyMonth : sortMonths)
                {
                    String[] yearAndMonth = keyMonth.split(" ");

                    int foundedYear = Integer.parseInt(yearAndMonth[0]);

                    int foundedMonth = Integer.parseInt(yearAndMonth[1]);

                    if (foundedYear<year)
                    {
                        i++;
                    }
                    else
                    {
                        if (foundedMonth>month)
                        {
                            break;
                        }
                        else
                        {
                            i++;
                        }
                    }
                }
                sortMonths.add(i,monthString);


                SaleAndAd saleAndAda = new SaleAndAd();

                saleAndAda.getSales().add(sale);

                mountSaleAd.put(monthString, saleAndAda);
            }
        }

        for(Ad ad : product.getAds())
        {
            cal.setTime(ad.getDateBegin());


            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);


            String monthString = Integer.toString(year) + ' ' + Integer.toString(month);


            if (mountSaleAd.containsKey(monthString))
            {

                mountSaleAd.get(monthString).getAds().add(ad);
            }
            else
            {
                int i = 0;
                for (String keyMonth : sortMonths)
                {
                    String[] yearAndMonth = keyMonth.split(" ");

                    int foundedYear = Integer.parseInt(yearAndMonth[0]);

                    int foundedMonth = Integer.parseInt(yearAndMonth[1]);

                    if (foundedYear<year)
                    {
                        i++;
                    }
                    else
                    {
                        if (foundedMonth>month)
                        {
                            break;
                        }
                        else
                        {
                            i++;
                        }
                    }
                }
                sortMonths.add(i,monthString);


                SaleAndAd saleAndAda = new SaleAndAd();

                saleAndAda.getAds().add(ad);

                mountSaleAd.put(monthString, saleAndAda);
            }



        }

        MonthsAmountsMargins result = new MonthsAmountsMargins();

        if (sortMonths.size()>0)
        {
            int lastAdCost = 0;

            int lastCount = 0;

            int lastMargin = 0;

            {
                SaleAndAd saleAndAd = mountSaleAd.get(sortMonths.get(0));


                for(Ad ad : saleAndAd.getAds())
                {
                    lastAdCost+=ad.getAmount();
                }

                for(Sale sale : saleAndAd.getSales())
                {
                    lastCount+= sale.getProduction().getCount();
                    lastMargin+=sale.getAmount();
                }
            }



            for(int i=1; i<sortMonths.size();i++)
            {
                SaleAndAd saleAndAd = mountSaleAd.get(sortMonths.get(i));

                int adCost = 0;

                for(Ad ad : saleAndAd.getAds())
                {
                    adCost+=ad.getAmount();
                }

                lastAdCost =  adCost - lastAdCost;

                int margin = 0;

                int count = 0;

                for(Sale sale : saleAndAd.getSales())
                {
                    count+= sale.getProduction().getCount();
                    margin+=sale.getAmount();
                }

                lastCount =  count - lastCount;

                lastMargin =  margin - lastMargin;

                result.getResult().add(new MonthAmountMargin(lastMargin,lastCount,sortMonths.get(i),lastAdCost));

            }
        }

        return result;
    }


    public ProductCosts getProductCosts(Product product)
    {

        int adCost = 0;
        for(Ad ad : product.getAds())
        {
            adCost+= ad.getAmount();
        }

        int otherCost = 0;
        int transportCost = 0;

        for(Sale sale : product.getSales())
        {
            otherCost+=sale.getOtherCosts();
            transportCost+=sale.getTransportationCosts();
        }

        for(Order order : product.getOrders())
        {
            otherCost+=order.getOtherCosts();
            transportCost+=order.getTransportationCosts();
        }

        int storageCost = 0;

        int productionCost = 0;

        for(Production production : product.getProduction())
        {
            otherCost+=production.getCostsStorage();
            productionCost+=production.getCostsProduction();
        }


        ProductCosts result = new ProductCosts(adCost,storageCost,otherCost,productionCost,transportCost);
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
