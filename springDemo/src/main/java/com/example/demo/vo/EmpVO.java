package com.example.demo.vo;

public class EmpVO {
	 private int num;
	 private String name;
	 private String title;
	 private int salary;
	  
	 public EmpVO() {
		// TODO Auto-generated constructor stub
	}
	public EmpVO(int num, String name, String title, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.title = title;
		this.salary = salary;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
