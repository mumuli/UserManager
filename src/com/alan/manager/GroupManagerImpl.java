package com.alan.manager;

import com.alan.dao.GroupDao;
import com.alan.po.Group;

public class GroupManagerImpl implements GroupManager {

	private GroupDao groupDao;
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	
	@Override
	public Group add(Group group) {
		// TODO Auto-generated method stub
		return groupDao.add(group);
	}

}
