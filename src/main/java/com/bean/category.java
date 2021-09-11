package com.bean;

import org.springframework.stereotype.Component;

@Component
public class category {
	private int cid;
	private String cname;
	private String payeeName;
	private Payee pname;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Payee getPname() {
		return pname;
	}
	public void setPname(Payee pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "" + cname +  "";
	}
	
}
