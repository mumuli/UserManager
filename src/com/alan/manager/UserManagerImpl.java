package com.alan.manager;

import java.util.List;

import com.alan.dao.UserDao;
import com.alan.po.User;
import com.alan.util.PageModel;

public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User add(User user) {
		this.userDao.save(user);
		return null;
	}
	
	@Override
	public User load(int uid) {
		// TODO Auto-generated method stub
		return this.userDao.load(uid);
	}

	@Override
	public List<User> listAll() {
		return this.userDao.loadAll();
	}

	@Override
	public List<User> list(PageModel pageModel) {
		return userDao.load(pageModel);
	}
}