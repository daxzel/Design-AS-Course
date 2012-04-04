package daxzel.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daxzel.model.domains.Role;
import daxzel.model.services.RoleService;
import daxzel.model.DAO.RoleDAO;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;

	@Transactional
	public void create() {
		Role role;
		role = new Role();
		role.setName("Администратор");
		roleDAO.add(role);
	}
}
