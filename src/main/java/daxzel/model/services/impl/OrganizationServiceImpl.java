package daxzel.model.services.impl;

import daxzel.model.DAO.OrganizationDAO;
import daxzel.model.domains.Organization;
import daxzel.model.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: daxzel
 * Date: 4/9/12
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDAO organizationDAO;

    public void add(Organization entity)
    {
        organizationDAO.addOrUpdate(entity);
    }

    public List<Organization> getAll()
    {
        return organizationDAO.getAll();
    }

    public Organization getByID(Long id)
    {
        return organizationDAO.getByID(id);
    }

    public void remove(Long id)
    {
        organizationDAO.remove(id);
    }
}
