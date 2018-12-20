package com.qetch.funning.enums;

public class WeekDayTest {

	public static void main(String[] args) {
		WeekDay day = WeekDay.FRIDAY;
		switch (day) {
		case FRIDAY:
			System.out.println(1);
			break;

		default:
			System.out.println(1);
			break;
		}
	}
}

enum WeekDay {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
