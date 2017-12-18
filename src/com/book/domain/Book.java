package com.book.domain;

public class Book {
	private int bid;
	private String bname;
	private String cate;
	private String actor;
	private int agio;
	private double price;
	private int num;
	private String description;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getAgio() {
		return agio;
	}
	public void setAgio(int agio) {
		this.agio = agio;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Book(int bid, String bname, String cate, String actor, int agio, double price, int num, String description) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.cate = cate;
		this.actor = actor;
		this.agio = agio;
		this.price = price;
		this.num = num;
		this.description = description;
	}
	public Book(String bname, String cate, String actor, int agio, double price, int num, String description) {
		super();
		this.bname = bname;
		this.cate = cate;
		this.actor = actor;
		this.agio = agio;
		this.price = price;
		this.num = num;
		this.description = description;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", cate=" + cate + ", actor=" + actor + ", agio=" + agio
				+ ", price=" + price + ", num=" + num + ", description=" + description + "]";
	}
}
