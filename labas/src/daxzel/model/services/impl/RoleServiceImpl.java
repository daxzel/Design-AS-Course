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
		roleDAO.add(entity);
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
	
	public void create() {
		roleDAO.drop();
		Role role;
		role = new Role();
		role.setName("Администратор");
		this.add(role);
		role = new Role();
		role.setName("Бухгалтер");
		this.add(role);
		role = new Role();
		role.setName("Директор");
		this.add(role);
	}
}
