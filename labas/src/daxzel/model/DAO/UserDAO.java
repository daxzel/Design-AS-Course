package daxzel.model.DAO;

import daxzel.model.domains.User;

public interface UserDAO extends AbstractDAO<User>  {
	User getUserByName(String name);
}
