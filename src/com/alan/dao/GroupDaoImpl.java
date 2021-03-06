package com.alan.dao;

import java.util.List;

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

	/* (non-Javadoc)
	 * @see com.alan.dao.GroupDao#loadAll()
	 */
	@Override
	public List<Group> loadAll() {
		List<Group> groupList = sessionFactory.getCurrentSession().createQuery("from Group").list();
		return groupList;
	}

}
