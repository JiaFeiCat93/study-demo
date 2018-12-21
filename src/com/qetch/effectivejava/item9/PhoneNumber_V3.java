package com.qetch.effectivejava.item9;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber_V3 {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;
	
	public PhoneNumber_V3(int areaCode, int prefix, int lineNumber) {
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
		if (!(obj instanceof PhoneNumber_V3)) {
			return false;
		}
		PhoneNumber_V3 pn = (PhoneNumber_V3) obj;
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
	
	// Remainder omitted
	
	public static void main(String[] args) {
		Map<PhoneNumber_V3, String> map = new HashMap<>();
		map.put(new PhoneNumber_V3(707, 867, 5309), "Jenny");
		
		System.out.println(map.get(new PhoneNumber_V3(707, 867, 5309))); // Jenny
		System.out.println(new PhoneNumber_V3(707, 867, 5309).hashCode()); // 1218060
	}
}
