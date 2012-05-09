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
//        Role role = entity.getRole();
//
//        if (role == null)
//        {
//            throw new RuntimeException("sddsfsdfa");
//        }
//        List<User> users = role.getUsers();
//
//        if (users==null)
//        {
//            ArrayList<User> userArrayList = new ArrayList<User>();
//            userArrayList.add(entity);
//            role.setUsers(userArrayList);
//        }
//        else
//        {
//            users.add(entity);
//            role.setUsers(users);
//        }
//
//
//        roleDAO.addOrUpdate(role);

        userDAO.addOrUpdate(entity);
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
	    User user = userDAO.getUserByName(name);

        return user;
	}

    @Transactional
	public void remove(Long id)
    {
		User user = getByID(id);
        user.getRole();
        //role.getUsers().remove(user);
        //roleDAO.addOrUpdate(role);

    }
}
