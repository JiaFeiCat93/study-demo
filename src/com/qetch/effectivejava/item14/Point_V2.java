package com.qetch.effectivejava.item14;

// Encapsulation of data by accessor methods and mutators
class Point_V2 {
	private double x;
	private double y;
	
	public Point_V2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
