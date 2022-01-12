package com.example.demo.vo;

import org.springframework.stereotype.Component;

@Component
public class EmpVO {

	private int no;
	private String ename;
	private int salary;
	private int dept;
	
	public EmpVO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpVO(int no, String ename, int salary, int dept) {
		super();
		this.no = no;
		this.ename = ename;
		this.salary = salary;
		this.dept = dept;
		
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	
	

	
}
