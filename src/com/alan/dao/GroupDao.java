package com.alan.dao;

import java.util.List;

import com.alan.po.Group;

public interface GroupDao {
	public Group add(Group group);
	public List<Group> loadAll();
}
