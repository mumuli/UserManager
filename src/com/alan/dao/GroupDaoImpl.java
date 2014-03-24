package com.alan.dao;

import org.hibernate.SessionFactory;

import com.alan.po.Group;

public class GroupDaoImpl implements GroupDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Group add(Group group) {
		sessionFactory.getCurrentSession().save(group);
		return group;
	}

}
