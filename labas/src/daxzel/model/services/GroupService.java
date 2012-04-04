package daxzel.model.services;

import daxzel.model.domains.Group;

public interface GroupService extends AbstractService<Group> {
	Group findGroupByNCP(Long NCP);
	void removeGroupByNCP(Long NCP);
}
