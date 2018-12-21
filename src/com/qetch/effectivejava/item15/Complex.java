package com.qetch.effectivejava.item15;

public final class Complex {
	// constant
	private static final Complex ZERO = new Complex(0, 0); // 0
	private static final Complex ONE = new Complex(1, 0); // 实数1
	private static final Complex I = new Complex(0, 1); // 纯虚数
	
	private final double re;
	private final double im;
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	// Accessors with no corresponding mutators
	public double realPart() {
		return re;
	}
	
	public double imaginaryPart() {
		return im;
	}
	
	public Complex add(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}
	
	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}
	
	public Complex multiply(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}
	
	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Complex)) {
			return false;
		}
		Complex c = (Complex) obj;
		return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
	}
	
	@Override
	public int hashCode() {
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(im);
		return result;
	}
	
	private int hashDouble(double val) {
		long longBit = Double.doubleToLongBits(val);
		return (int) (longBit ^ (longBit >>> 32));
	}
	
	@Override
	public String toString() {
		return "(" + re + "+" + im + "i)";
	}
	
	public static void main(String[] args) {
		Complex c = new Complex(1, 2);
		System.out.println(c.toString());// (1.0+2.0i)
		
		Complex c2 = new Complex(2, 1);
		
		System.out.println(c.add(c2));// (3.0+3.0i)
		System.out.println(c.subtract(c2));// (-1.0+1.0i)
		System.out.println(c.multiply(c2));// (0.0+5.0i)
		System.out.println(c.divide(c2));// (0.8+0.6i)
		System.out.println(c.equals(c2));// false
		System.out.println(c.equals(new Complex(1, 2)));// true
		System.out.println(c.hashCode());// -32505329
		System.out.println(c2.hashCode());// -1048049
	}
}
