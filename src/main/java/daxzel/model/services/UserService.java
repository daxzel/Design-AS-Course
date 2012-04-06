package daxzel.model.services;

import daxzel.model.domains.User;

public interface UserService extends AbstractService<User> {

	public User getUserByName(String name);
	
}
