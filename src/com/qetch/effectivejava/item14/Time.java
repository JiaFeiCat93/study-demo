package com.qetch.effectivejava.item14;

// Public class with exposed immutable fields - questionable
public final class Time {
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	
	public final int hour;
	public final int minute;
	
	public Time(int hour, int minute) {
		if (hour < 0 || hour > HOURS_PER_DAY) {
			throw new IllegalArgumentException("Hour: " + hour);
		}
		if (minute < 0 || minute > MINUTES_PER_HOUR) {
			throw new IllegalArgumentException("Minute: " + minute);
		}
		this.hour = hour;
		this.minute = minute;
	}
	
	// Remainder omitted
	
	public static void main(String[] args) {
		Time t1 = new Time(2, 43);
		Time t2 = new Time(25, 2);
		Time t3 = new Time(3, 82);
	}
}
