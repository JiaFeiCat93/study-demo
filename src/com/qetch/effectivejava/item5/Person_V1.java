package com.qetch.effectivejava.item5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person_V1 {
	private final Date birthDate;
	
	public Person_V1(Date date) {
		this.birthDate = date;
	}
	
	public boolean isBabyBoomer() {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
		
		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Person_V1 person = new Person_V1(new Date());
		for (int i = 0; i < 10000000l; i++) {
			System.out.println(person.isBabyBoomer());
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
