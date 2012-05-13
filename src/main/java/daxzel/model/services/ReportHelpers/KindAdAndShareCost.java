package daxzel.model.services.ReportHelpers;

import daxzel.model.domains.KindAd;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class KindAdAndShareCost {

    private KindAd kindAd;

    public KindAd getKindAd() {
        return kindAd;
    }

    public KindAdAndShareCost(KindAd kindAd,long shareCost)
    {
        this.kindAd = kindAd;
        this.shareCost = shareCost;
    }


    public void setKindAd(KindAd kindAd) {
        this.kindAd = kindAd;
    }

    public long getShareCost() {
        return shareCost;
    }

    public void setShareCost(long shareCost) {
        this.shareCost = shareCost;
    }

    private long shareCost;




}
