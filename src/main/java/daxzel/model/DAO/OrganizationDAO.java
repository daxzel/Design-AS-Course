package daxzel.model.DAO;

import daxzel.model.domains.Organization;

/**
 * Created by IntelliJ IDEA.
 * User: daxzel
 * Date: 4/9/12
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrganizationDAO extends AbstractDAO<Organization> {
    Organization getOrganizationByName(String name);
}
