package com.bean;

import java.sql.Time;
import java.sql.Date;

public class Account {
	
	int a_id;
	String aname;
	String balance;
	Date currentDate;
	Time currentTime;
	int id;
	AccountType type;
	
	public Time getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Time currentTime) {
		this.currentTime = currentTime;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	
}
