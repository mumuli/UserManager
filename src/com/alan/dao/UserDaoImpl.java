package com.alan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alan.po.User;
import com.alan.util.PageModel;

public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		System.out.println("UserDaoImpl save...");
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}
	
	@Override
	public User load(int uid) {
		// TODO Auto-generated method stub
		User user = (User)this.sessionFactory.getCurrentSession().load(User.class, uid);
		//System.out.println("user.name: " + user.getName());
		return user;
	}

	@Override
	public List<User> loadAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User").list();
		
		return users;
	}

	@Override
	public List<User> load(PageModel pageModel) {
		// use hql to get total count
		String countHql = "select count(*) from User";
		Session session = sessionFactory.getCurrentSession();
		long totalCount = (Long)session.createQuery(countHql).list().get(0);
		pageModel.setTotalCount(totalCount);
		
		int page = pageModel.getPage();
		int pageCount = pageModel.getPageCount();
		int pageSize = pageModel.getPageSize();
		if (page > pageCount) {
			page = pageCount;
		}
		
		int startIndex = (page - 1) * pageSize;
		List<User> users = session.createQuery("from User")
								  .setFirstResult(startIndex)
								  .setMaxResults(pageSize)
								  .list();
		return users;
	}
}
