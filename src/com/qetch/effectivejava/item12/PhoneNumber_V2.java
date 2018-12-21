package com.qetch.effectivejava.item12;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber_V2 {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;
	
	public PhoneNumber_V2(int areaCode, int prefix, int lineNumber) {
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
		if (!(obj instanceof PhoneNumber_V2)) {
			return false;
		}
		PhoneNumber_V2 pn = (PhoneNumber_V2) obj;
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
		
	public int compareTo(PhoneNumber_V2 pn) {
		// Compare area codes
		int areaCodeDiff = areaCode - pn.areaCode;
		if (areaCodeDiff != 0) {
			return areaCodeDiff;
		}
		// Area codes are equal, compare prefixes
		int prefixDiff = prefix - pn.prefix;
		if (prefixDiff != 0) {
			return prefixDiff;
		}
		// Area codes and prefixes are equal, compare line numbers
		return lineNumber - pn.lineNumber;
	}
	
	// Remainder omitted
	
	public static void main(String[] args) {
		Map<PhoneNumber_V2, String> map = new HashMap<>();
		map.put(new PhoneNumber_V2(707, 867, 5309), "Jenny");
		
		System.out.println(map.get(new PhoneNumber_V2(707, 867, 5309))); // Jenny
		System.out.println(new PhoneNumber_V2(707, 867, 5309).hashCode()); // 1218060
		
		System.out.println(new PhoneNumber(101, 5, 121).compareTo(new PhoneNumber(101, 2, 121))); // 1
		System.out.println(new PhoneNumber(101, 5, 121).compareTo(new PhoneNumber(101, 5, 121))); // 0
		System.out.println(new PhoneNumber(12, 5, 121).compareTo(new PhoneNumber(101, 2, 141))); // -1
	}
}
