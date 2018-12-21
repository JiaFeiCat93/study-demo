package com.qetch.effectivejava.item12;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {
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
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}
		
	public int compareTo(PhoneNumber pn) {
		// Compare area codes
		if (areaCode < pn.areaCode) {
			return -1;
		}
		if (areaCode > pn.areaCode) {
			return 1;
		}
		// Area codes are equal, compare prefixes
		if (prefix < pn.prefix) {
			return -1;
		}
		if (prefix > pn.prefix) {
			return 1;
		}
		// Area codes and prefixes are equal, compare line numbers
		if (lineNumber < pn.lineNumber) {
			return -1;
		}
		if (lineNumber > pn.lineNumber) {
			return 1;
		}
		return 0;
	}
	
	// Remainder omitted
	
	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<>();
		map.put(new PhoneNumber(707, 867, 5309), "Jenny");
		
		System.out.println(map.get(new PhoneNumber(707, 867, 5309))); // Jenny
		System.out.println(new PhoneNumber(707, 867, 5309).hashCode()); // 1218060
		
		System.out.println(new PhoneNumber(101, 5, 121).compareTo(new PhoneNumber(101, 2, 121))); // 1
		System.out.println(new PhoneNumber(101, 5, 121).compareTo(new PhoneNumber(101, 5, 121))); // 0
		System.out.println(new PhoneNumber(12, 5, 121).compareTo(new PhoneNumber(101, 2, 141))); // -1
	}
}
