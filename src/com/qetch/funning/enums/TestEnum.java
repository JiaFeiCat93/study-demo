package com.qetch.funning.enums;

public class TestEnum {
	public static void main(String[] args) {
		weekday mon = weekday.mon;
		weekday tue = weekday.tue;
		weekday thus = weekday.thus;
		weekday fri = weekday.fri;
		
		/**
		 * result，枚举类weekday在初始化时，会调用5次构造方法来初始化它的5个元素；初始化完毕后，以后每次调用调用元素，都不再调用构造方法
		 */
//		no args
//		have args 2
//		have args 3
//		no args
//		no args

	}

	public enum weekday {
		mon(), tue(2), wes(3), thus(), fri;
		private weekday() {
			System.out.println("no args");
		}

		private weekday(int i) {
			System.out.println("have args " + i);
		}
	}
}
