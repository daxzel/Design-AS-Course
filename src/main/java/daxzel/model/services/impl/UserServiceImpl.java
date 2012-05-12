package daxzel.model.services.impl;

import java.util.ArrayList;
import java.util.List;

import daxzel.model.DAO.RoleDAO;
import daxzel.model.domains.Role;
import daxzel.model.services.UserService;

import daxzel.model.DAO.UserDAO;

import daxzel.model.domains.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Transactional
	public void add(User entity)
	{
        userDAO.addOrUpdate(entity);
	}

	public List<User> getAll()
    {
		return userDAO.getAll();
    }

	@Transactional
	public User getByID(Long id)
    {
		return userDAO.getByID(id);
    }
    
	@Transactional
	public User getUserByName(String name)
	{
	    User user = userDAO.getUserByName(name);

        return user;
	}

    @Transactional
	public void remove(Long id)
    {
        userDAO.remove(id);
    }
}
