package org.java.db;

import java.text.DecimalFormat;

public class Pizza {
	
	private String name;
	private double price;
	
	public Pizza(String name, double price) {
		setName(name);
		setPrice(price);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getFormattedPrice() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return decimalFormat.format(price);
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
