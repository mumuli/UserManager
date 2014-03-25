package com.alan.manager;

import java.util.List;

import com.alan.po.User;
import com.alan.util.PageModel;

public interface UserManager {
	
	public User add(User user);
	
	public User load(int uid);

	public List<User> listAll();
	
	public List<User> list(PageModel pageModel);
	
	public int delete(int[] uidsToBeDeleted);
	
	public User modify(User user);
}
