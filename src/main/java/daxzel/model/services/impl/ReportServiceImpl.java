package daxzel.model.services.impl;

import daxzel.model.domains.Ad;
import daxzel.model.domains.KindAd;
import daxzel.model.domains.Organization;
import daxzel.model.domains.Product;
import daxzel.model.services.ReportHelpers.KindAdAndShareCost;
import daxzel.model.services.ReportHelpers.OrganizationAndShareCost;
import daxzel.model.services.ReportHelpers.ShareAdCosts;
import daxzel.model.services.ReportService;
import org.springframework.stereotype.Service;

import java.awt.event.AdjustmentListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ReportServiceImpl implements ReportService {



    public ShareAdCosts GetShareAdCosts(Product product,Date begin,Date end){

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


}
