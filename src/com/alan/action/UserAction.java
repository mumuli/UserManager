package com.alan.action;

import java.util.List;

import com.alan.manager.GroupManager;
import com.alan.manager.UserManager;
import com.alan.po.Group;
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
	
	private GroupManager groupMgr;
	
	private List<User> userList;
	
	private List<Group> groupList;
	
	private int page;
	
	private int pageSize;
	
	private PageModel pageModel;
	
	/**
	 * JSON string which contains all uids to be operated
	 */
	private String uids;
	
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
	
	/**
	 * @param groupMgr the groupMgr to set
	 */
	public void setGroupMgr(GroupManager groupMgr) {
		this.groupMgr = groupMgr;
	}
	
	public User getUser() {
		return this.user;
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
	 * @param uids the uids to set
	 */
	public void setUids(String uids) {
		this.uids = uids;
	}
	
	/**
	 * @return the groupList
	 */
	public List<Group> getGroupList() {
		return groupList;
	}
	
	public String add() throws Exception {
		System.out.println("UserAction add...");
		System.out.println("user.name: " + this.user.getName());
		this.userMgr.add(user);
		return SUCCESS;
	}
	
	public String load() throws Exception {
		int[] uidsArray = getUids();
		if (uidsArray.length > 0) {
			groupList = groupMgr.loadAll();
			user = userMgr.load(uidsArray[0]);
		}
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
		int[] uidsArray = getUids();

		if (uidsArray.length > 0) {
			userMgr.delete(uidsArray);
		}
		
		return LOAD_LIST;
	}

	public String modify() throws Exception {
		userMgr.modify(user);
		return "load_load";
	}
	
	private int[] getUids() {
		Gson gson = new Gson();
		int[] uidsArray = gson.fromJson(uids, int[].class);
		return uidsArray;
	}
}
