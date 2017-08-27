package com.deli.entity;

public class Order {
	private String userName;
	private String dishName;
	private int dishId;
	private String email;
	private String cell;
	private String time;
	private String place;
	private int price;
	private String payment;
	private boolean isPaid;
	
	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	private boolean isPicked;
	private String note;

	public Order(String userName, String dishName, int dishId, String email, String cell, String time, String place, int price,
			String payment, boolean isPaid, boolean isPicked, String note) {
		super();
		this.userName = userName;
		this.dishName = dishName;
		this.dishId = dishId;
		this.email = email;
		this.cell = cell;
		this.time = time;
		this.place = place;
		this.price = price;
		this.payment = payment;
		this.isPaid = isPaid;
		this.isPicked = isPicked;
		this.note = note;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDish(String dishName) {
		this.dishName = dishName;
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

	public boolean isPicked() {
		return isPicked;
	}

	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}

	@Override
	public String toString() {
		return "Order [userName=" + userName + ", dishName=" + dishName + ", dishId=" + dishId + ", email=" + email + ", cell=" + cell
				+ ", time=" + time + ", place=" + place + ", price=" + price + ", payment=" + payment + ", isPaid="
				+ isPaid + ", isPicked=" + isPicked + ", note" + "]";
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

}
