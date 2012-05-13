package daxzel.model.services.ReportHelpers;

import daxzel.model.domains.KindAd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShareAdCosts {

    List<OrganizationAndShareCost> organizationAndShareCostList = new ArrayList<OrganizationAndShareCost>();

    List<KindAdAndShareCost> kindAdAndShareCostList  = new ArrayList<KindAdAndShareCost>();

    public List<OrganizationAndShareCost> getOrganizationAndShareCostList() {
        return organizationAndShareCostList;
    }

    public void setOrganizationAndShareCostList(List<OrganizationAndShareCost> organizationAndShareCostList) {
        this.organizationAndShareCostList = organizationAndShareCostList;
    }

    public List<KindAdAndShareCost> getKindAdAndShareCostList() {
        return kindAdAndShareCostList;
    }

    public void setKindAdAndShareCostList(List<KindAdAndShareCost> kindAdAndShareCostList) {
        this.kindAdAndShareCostList = kindAdAndShareCostList;
    }
}
