package com.qetch.effectivejava.item15;

// Immutable class with static factories instead of constructors
public class Complex_V2 {
	private final double re;
	private final double im;
	
	private Complex_V2(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public static Complex_V2 valueOf(double re, double im) {
		return new Complex_V2(re, im);
	} 
	
	public static Complex_V2 valueOfPolar(double r, double theta) {
		return new Complex_V2(r * Math.cos(theta), r * Math.sin(theta));
	}
	
	// Remainder unchanged with Complex.Class
}
