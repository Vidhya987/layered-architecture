package com.pace.library.entity;

public class Book {
	private int bookId;
	private String bname;
	private String author;
	private float price;
	public Book(int bookId, String bname, String author, float price) {
		super();
		this.bookId = bookId;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
