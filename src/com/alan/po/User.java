package com.alan.po;

import java.util.Date;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

public class User {
	
	private int id;
	
	private String name;
	
	private Date birthday;
	
	private Date hireDate;
	
	private Group group;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	//@TypeConversion(converter="com.alan.type.converter.UserDateTypeConverter")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getHireDate() {
		return hireDate;
	}

	//@TypeConversion(converter="com.alan.type.converter.UserDateTypeConverter")
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
