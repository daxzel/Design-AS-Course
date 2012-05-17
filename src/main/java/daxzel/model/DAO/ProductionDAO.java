package daxzel.model.DAO;

import daxzel.model.domains.Production;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductionDAO extends AbstractDAO<Production>  {
    List<Production> getEmptyProduction();
}
