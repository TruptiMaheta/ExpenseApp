package com.bean;

public class subCategory {
	private int sid;
	private String sname;
	private category cname;
	private String subCategory;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public category getCname() {
		return cname;
	}
	public void setCname(category cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return " " + cname + "";
	}
	
}
