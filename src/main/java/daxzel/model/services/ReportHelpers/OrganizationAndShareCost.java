package daxzel.model.services.ReportHelpers;

import daxzel.model.domains.Organization;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrganizationAndShareCost {

    private Organization organization;

    public OrganizationAndShareCost(Organization organization,long shareCost)
    {
        this.organization = organization;
        this.shareCost = shareCost;
    }



    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public long getShareCost() {
        return shareCost;
    }

    public void setShareCost(long shareCost) {
        this.shareCost = shareCost;
    }

    private long shareCost;

}
