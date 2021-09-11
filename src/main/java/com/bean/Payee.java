package com.bean;

import org.springframework.stereotype.Component;

@Component
public class Payee {
	private int pid;
	private String pname;
	private UserBean user;
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return " " + pname + "";
	}
	
}
