package com.bean;

import java.sql.Date;
import java.sql.Time;

public class expenses {
	private int expenseId;
	private String payeeName;
	private int ammount;
	private Time timeexp;
	private Date  dateexp;
	private String description;
	private int userId;
	private AccountType type;
	String categorydatalist;
	String subcategorydatalist;
	private String image;
	private int useraccountID;
	
	
	public String getCategorydatalist() {
		return categorydatalist;
	}
	public void setCategorydatalist(String categorydatalist) {
		this.categorydatalist = categorydatalist;
	}
	public String getSubcategorydatalist() {
		return subcategorydatalist;
	}
	public void setSubcategorydatalist(String subcategorydatalist) {
		this.subcategorydatalist = subcategorydatalist;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public Time getTimeexp() {
		return timeexp;
	}
	public void setTimeexp(Time timeexp) {
		this.timeexp = timeexp;
	}
	public Date getDateexp() {
		return dateexp;
	}
	public void setDateexp(Date dateexp) {
		this.dateexp = dateexp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	public int getUseraccountID() {
		return useraccountID;
	}
	public void setUseraccountID(int useraccountID) {
		this.useraccountID = useraccountID;
	}
	
	

	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ExpenseBean [expenseId=" + expenseId + ", payeeName=" + payeeName + ", ammount=" + ammount
				+ ", timeexp=" + timeexp + ", dateexp=" + dateexp + ", description=" + description + ", userId="
				+ userId + ", accountName=" + type + ", image=" + image + ", useraccountID=" + useraccountID
				+ "]";
	}
	
}