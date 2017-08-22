package com.deli.web;

public class Order {
	private int id;
	private String userName;
	private String dish;
	private String email;
	private String cell;
	private String time;
	private String place;
	private int price;
	private String payment;
	private boolean isPaid;
	private boolean isPicked;
	
	public Order(int id, String userName, String dish, String email, String cell, String time, String place, int price,
			String payment, boolean isPaid, boolean isPicked) {
		super();
		this.id = id;
		this.userName = userName;
		this.dish = dish;
		this.email = email;
		this.cell = cell;
		this.time = time;
		this.place = place;
		this.price = price;
		this.payment = payment;
		this.isPaid = isPaid;
		this.isPicked = isPicked;
	}

	public Order(String userName, String dish, String email, String cell, String time, String place, int price,
			String payment, boolean isPaid, boolean isPicked) {
		super();
		this.userName = userName;
		this.dish = dish;
		this.email = email;
		this.cell = cell;
		this.time = time;
		this.place = place;
		this.price = price;
		this.payment = payment;
		this.isPaid = isPaid;
		this.isPicked = isPicked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public boolean isPicked() {
		return isPicked;
	}

	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}
	
	
	
}
