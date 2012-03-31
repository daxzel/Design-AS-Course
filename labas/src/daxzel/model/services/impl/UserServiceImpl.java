package daxzel.model.services.impl;

import java.util.List;

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

	@Transactional
	public void add(User entity)
	{
		userDAO.add(entity);
	}

	@Transactional
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
		return userDAO.getUserByName(name);
	}
	
	@Transactional
	public void remove(Long id)
    {
		userDAO.remove(id);
    }
}
