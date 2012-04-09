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

    @Transactional
    public void add(Organization entity)
    {
        organizationDAO.addOrUpdate(entity);
    }

    @Transactional
    public List<Organization> getAll()
    {
        return organizationDAO.getAll();
    }

    @Transactional
    public Organization getByID(Long id)
    {
        return organizationDAO.getByID(id);
    }

    @Transactional
    public void remove(Long id)
    {
        organizationDAO.remove(id);
    }
}
