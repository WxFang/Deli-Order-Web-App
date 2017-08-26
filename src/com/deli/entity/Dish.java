package com.deli.entity;

public class Dish {
	private String name;
	private int id;
	private int price;
	
	public String getDishName() {
		return name;
	}
	public void setDishName(String name) {
		this.name = name;
	}
	public int getDishId() {
		return id;
	}
	public void setDishId(int id) {
		this.id = id;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Dish(int id, String name, int price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "Dish [dishName=" + name + ", dishId=" + id + ", price=" + price + "]";
	}
	
	
	
}
