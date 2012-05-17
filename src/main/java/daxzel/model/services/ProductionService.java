package daxzel.model.services;

import daxzel.model.domains.Production;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductionService extends AbstractService<Production> {
    List<Production> getEmptyProduction();
}
