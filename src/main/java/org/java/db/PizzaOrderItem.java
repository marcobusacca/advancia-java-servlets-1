package org.java.db;

import java.text.DecimalFormat;

public class PizzaOrderItem {
	
    private Pizza pizza;
    private int quantity;
    private double subtotal;

    public PizzaOrderItem(Pizza pizza, int quantity) {
        setPizza(pizza);
        setQuantity(quantity);
        setSubtotal(calculateSubtotal());
    }

    public Pizza getPizza() {
		return pizza;
	}
	private void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public int getQuantity() {
		return quantity;
	}
	private void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	private void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public void increaseQuantity() {
		this.quantity++;
	}
	public double calculateSubtotal() {
		return pizza.getPrice() * quantity;
	}
	public void refreshSubtotal() {
		this.subtotal = calculateSubtotal();
	}
	public String getFormattedSubtotal() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return decimalFormat.format(subtotal);
	}

	@Override
	public String toString() {
		return getPizza().getName() + " - " + getQuantity();
	}
}
