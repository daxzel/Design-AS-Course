package daxzel.model.DAO;

import daxzel.model.domains.KindAd;

public interface KindAdDAO extends AbstractDAO<KindAd>  {
    KindAd getKindAdByName(String name);
}
