package com.example.demo.vo;

public class reportVO {

	private int oNum;
	private String uid;
	private int no;
	private String title;
	private int price;
	private String pub;
	private String pubdate;
	private int qty;
	private String oDate;
	private int total;
	private String big;
	public reportVO() {
		// TODO Auto-generated constructor stub
	}
	public reportVO(int oNum, String uid, int no, String title, int price, String pub, String pubdate, int qty,
			String oDate, int total, String big) {
		super();
		this.oNum = oNum;
		this.uid = uid;
		this.no = no;
		this.title = title;
		this.price = price;
		this.pub = pub;
		this.pubdate = pubdate;
		this.qty = qty;
		this.oDate = oDate;
		this.total = total;
		this.big = big;
	}
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
		this.big = big;
	}
	
}