package daxzel.model.DAO;

import daxzel.model.domains.Group;

public interface GroupDAO extends AbstractDAO<Group>  {
	Group findGroupByNCP(Long NCP);
	void removeGroupByNCP(Long NCP);
}

