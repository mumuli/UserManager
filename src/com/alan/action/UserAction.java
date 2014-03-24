package com.alan.action;

import java.util.List;

import com.alan.manager.UserManager;
import com.alan.po.User;
import com.alan.util.PageModel;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private static final String LOAD_LIST = "load_list";

	private static final String LOAD = "load";

	private static final String LIST = "list";

	private static final long serialVersionUID = 1L;

	private User user;
	
	private UserManager userMgr;
	
	private int uid;
	
	private List<User> userList;
	
	private int page;
	
	private int pageSize;
	
	private PageModel pageModel;
	
	private String uidsToBeDeleted;
	
	public UserAction() {
		page = 1;
		pageSize = 20;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		this.user = new User();
		return this.user;
	}
	
	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}

	public List<User> getUserList() {
		return userList;
	}
	
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageModel getPageModel() {
		return pageModel;
	}
	
	/**
	 * @param uidsToBeDeleted the uidsToBeDeleted to set
	 */
	public void setUidsToBeDeleted(String uidsToBeDeleted) {
		this.uidsToBeDeleted = uidsToBeDeleted;
	}
	
	public String add() throws Exception {
		System.out.println("UserAction add...");
		System.out.println("user.name: " + this.user.getName());
		this.userMgr.add(user);
		return SUCCESS;
	}
	
	public String load() throws Exception {
		System.out.println("uid: " + this.uid);
		this.user = this.userMgr.load(uid);
		return LOAD;
	}
	
	public String list() throws Exception {
		pageModel = new PageModel();
		pageModel.setPage(page);
		pageModel.setPageSize(pageSize);
		
		//this.userList = userMgr.listAll();
		userList = userMgr.list(pageModel);
		return LIST;
	}
	
	public String delete() throws Exception {
		Gson gson = new Gson();
		int[] uids = gson.fromJson(uidsToBeDeleted, int[].class);
		
		System.out.println("uids: " + uids);
		if (uids.length > 0) {
			userMgr.delete(uids);
		}
		
		return LOAD_LIST;
	}
}
