package com.example.demo.vo;

public class User {
	
	private int num;
	private String name;
	private String phone;
	private String email;
	
	public User(int num, String name, String phone, String email) {
		super();
		setNum(num);
		setName(name);
		setPhone(phone);
		setEmail(email);
	}
	public User() {
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
