package com.bean;

import org.springframework.stereotype.Component;
@Component
public class AccountType {
	int at_id;
	String type;
	@Override
	public String toString() {
		return " " + type + "";
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}