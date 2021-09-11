package com.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserBean {
	int userId;
	@NotBlank(message="Please Enter FirstName")
	@Pattern(regexp="[^0-9]*",message="Please enter only alphaets")
	String firstName;
	@NotBlank(message="Please Enter Email")
	/* @Email(message="please enter valid email") */
	@Pattern(regexp="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",message="please enter valid email address")
	String email;
	@NotBlank(message="Please Enter Password")
	@Size(min=8,max=16,message="Length must be 8 to 16")
	String password;
	//private String[] genderArray = {"Male", "Female"};
	private RoleBean roleName;
	private String filepath;
	

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public RoleBean getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleBean roleName) {
		this.roleName = roleName;
	}

	public int getUserId() {
		
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
