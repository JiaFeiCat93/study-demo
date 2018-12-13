package com.qetch.effectivejava.item5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person_V2 {
	private final Date birthDate;
	
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
	
	public Person_V2(Date date) {
		this.birthDate = date;
	}
	
	public boolean isBabyBoomer() {
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Person_V2 person = new Person_V2(new Date());
		for (int i = 0; i < 10000000l; i++) {
			System.out.println(person.isBabyBoomer());
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
