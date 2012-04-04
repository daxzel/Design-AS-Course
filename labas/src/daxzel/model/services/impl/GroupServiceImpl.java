package daxzel.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import daxzel.model.domains.Group;
import daxzel.model.services.GroupService;
import daxzel.model.DAO.GroupDAO;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDAO groupDAO;

	@Transactional
	public void add(Group entity)
	{
		groupDAO.addOrUpdate(entity);
	}

	@Transactional
	public List<Group> getAll()
    {
		return groupDAO.getAll();
    }

	@Transactional
	public Group getByID(Long id)
    {
		return groupDAO.getByID(id);
    }
    	
	@Transactional
	public void remove(Long id)
    {
		groupDAO.remove(id);
    }
	
	@Transactional
	public Group findGroupByNCP(Long NCP)
	{
		return groupDAO.findGroupByNCP(NCP);
	}
	
	@Transactional
	public void removeGroupByNCP(Long NCP)
	{
		groupDAO.removeGroupByNCP(NCP);
	}
	
}