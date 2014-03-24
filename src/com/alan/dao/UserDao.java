package com.alan.dao;

import java.util.List;

import com.alan.po.User;
import com.alan.util.PageModel;

public interface UserDao {
	
	public User save(User user);
	
	public User load(int uid);
	
	public List<User> loadAll();
	
	public List<User> load(PageModel pageModel);
	
	public int delete(int[] uidsToBeDeleted);

}
