package com.deli.entity;

public class Dish {
	private String dishName;
	private int dishId;
	
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	
	
	public Dish(String dishName, int dishId) {
		super();
		this.dishName = dishName;
		this.dishId = dishId;
	}
	
	@Override
	public String toString() {
		return "Dish [dishName=" + dishName + ", dishId=" + dishId + "]";
	}
	
	
}
