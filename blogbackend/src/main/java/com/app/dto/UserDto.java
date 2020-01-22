package com.app.dto;

public class UserDto {
	private String name,email,password,confirm,gender;
	private long contact;
	
	public UserDto() {
	
	}

	public UserDto(String name, String email, String password, String confirm, String gender, long contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.gender = gender;
		this.contact = contact;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
}
