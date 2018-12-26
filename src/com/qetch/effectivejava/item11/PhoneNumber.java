package com.qetch.effectivejava.item11;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber implements Cloneable {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}
	
	private static void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber pn = (PhoneNumber) obj;
		return pn.areaCode == areaCode && pn.prefix == prefix && pn.lineNumber == lineNumber;
	}
	
	// Lazily initialized, cached hashCode
	private volatile int hashCode; // (See Item 71)
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = 17;
			result = 31 * result + areaCode;
			result = 31 * result + prefix;
			result = 31 * result + lineNumber;
			hashCode = result;
		}
		return result;
	}
	
	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(); // Can't happen
		}
	}
	
	// Remainder omitted
	
	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<>();
		map.put(new PhoneNumber(707, 867, 5309), "Jenny");
		
		System.out.println(map.get(new PhoneNumber(707, 867, 5309))); // Jenny
		System.out.println(new PhoneNumber(707, 867, 5309).hashCode()); // 1218060
		
		PhoneNumber pn1 = new PhoneNumber(707, 867, 5309);
		PhoneNumber pn2 = pn1.clone();
		System.out.println(pn1);
		System.out.println(pn2);
	}
}
