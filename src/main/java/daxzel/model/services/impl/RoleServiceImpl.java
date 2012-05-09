package daxzel.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.Role;
import daxzel.model.services.RoleService;
import daxzel.model.DAO.RoleDAO;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;

	@Transactional
	public void add(Role entity)
	{
		roleDAO.addOrUpdate(entity);
	}

	@Transactional
	public List<Role> getAll()
    {
		return roleDAO.getAll();
    }

	@Transactional
	public Role getByID(Long id)
    {
		return roleDAO.getByID(id);
    }
    	
	@Transactional
	public void remove(Long id)
    {
		roleDAO.remove(id);
    }

    @Transactional
    public void drop()
    {
        roleDAO.drop();
    }

    @Transactional
    public Role getRoleByName(String name)
    {
        return roleDAO.getRoleByName(name);
    }

	public void create() {
		this.drop();

		Role role;
		role = new Role();
		role.setName("Администратор");
		this.add(role);

		role = new Role();
		role.setName("Менеджер по продажам");
		this.add(role);

		role = new Role();
		role.setName("Директор");
		this.add(role);

        role = new Role();
        role.setName("Главный бухгалтер");
        this.add(role);

        role = new Role();
        role.setName("Экономист");
        this.add(role);

	}
}
