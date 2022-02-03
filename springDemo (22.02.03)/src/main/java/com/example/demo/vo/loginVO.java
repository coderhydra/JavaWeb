package com.example.demo.vo;

public class loginVO {
	
	private String uid;
	private String pwd;
	
	public loginVO() {
		// TODO Auto-generated constructor stub
	}

	public loginVO(String uid, String pwd) {
		super();
		this.uid = uid;
		this.pwd = pwd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
