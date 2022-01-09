package com.tjoeun.vo;

public class login2VO {
	private int num;
	private String name;
	private String phone;
	private String email;

	public login2VO() {}

	public login2VO(int num, String name, String phone, String email) {
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.email = email;
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
