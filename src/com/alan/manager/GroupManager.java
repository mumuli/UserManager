package com.alan.manager;



import java.util.List;

import com.alan.po.Group;

public interface GroupManager {
	public Group add(Group group);
	public List<Group> loadAll();
}
