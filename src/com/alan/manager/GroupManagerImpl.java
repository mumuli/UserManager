package com.alan.manager;

import java.util.List;

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

	/* (non-Javadoc)
	 * @see com.alan.manager.GroupManager#loadAll()
	 */
	@Override
	public List<Group> loadAll() {
		return groupDao.loadAll();
	}
}
