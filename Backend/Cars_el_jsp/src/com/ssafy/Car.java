package com.ssafy;

public class Car {
	String number;
	String model;
	int price;
	String brand;
	
	public Car() {
	}
	public Car(String number, String model, int price, String brand) {
		super();
		this.number = number;
		this.model = model;
		this.price = price;
		this.brand = brand;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
