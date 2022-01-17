package com.example.demo.vo;

public class orderVO {

	private String uid;
	private int no;
	private String title;
	private int price;
	private String pub;
	private String pubdate;
	private int qty;
	private String oDate;
	 public orderVO() {
		// TODO Auto-generated constructor stub
	}
	public orderVO(String line) {
		String[] token = line.split("\\|");
		setUid(token[0]);
		setNo(Integer.parseInt(token[1]));
		setTitle(token[2]);
		setPrice(Integer.parseInt(token[3]));
		setPub(token[4]);
		setPubdate(token[5]);
		setQty(Integer.parseInt(token[6]));
		setoDate(token[7]);
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getoDate() {
		return oDate;
	}
	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	 
}