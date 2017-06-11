package com.msp.spring.bean;

public class Car {
	private String brand;
	private int price;
	private String corp;
	private int maxSpeed;
	
	public Car(String brand, int price, String corp) {
		super();
		this.brand = brand;
		this.price = price;
		this.corp = corp;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", corp=" + corp + ", maxSpeed=" + maxSpeed + "]";
	}
}
