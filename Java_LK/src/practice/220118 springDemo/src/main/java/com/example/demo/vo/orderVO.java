package com.example.demo.vo;

public class orderVO {

	private int oNum;
	private String uid;
	private int no;
	private String title;
	private int price;
	private String pub;
	private String pubdate;
	private int qty;
	private String oDate;
	private String big;
	 public orderVO() {
		// TODO Auto-generated constructor stub
	}
	public orderVO(String line) {
		String[] token = line.split("\\|");
		setoNum(Integer.parseInt(token[0]));
		setUid(token[1]);
		setNo(Integer.parseInt(token[2]));
		setTitle(token[3]);
		setPrice(Integer.parseInt(token[4]));
		setPub(token[5]);
		setPubdate(token[6]);
		setQty(Integer.parseInt(token[7]));
		setoDate(token[8]);
		setBig(big());
		
	}
	
	public String big() {
		int total = getQty()*getPrice();
		if (total >= 50000) {
			return "큰손님";
		}
		return "일반";
	}
	
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
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
	 

	
}