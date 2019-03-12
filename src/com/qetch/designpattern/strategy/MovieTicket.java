package com.qetch.designpattern.strategy;

public class MovieTicket {
	private double price;
	private Discount discount;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "MovieTicket [price=" + price + ", discount=" + discount + "]";
	}
}
