package daxzel.model.DAO;

import daxzel.model.domains.Role;

public interface RoleDAO extends AbstractDAO<Role>  {
	void drop();
    Role getUserRole(String username);
    Role getRoleByName(String name);
}
