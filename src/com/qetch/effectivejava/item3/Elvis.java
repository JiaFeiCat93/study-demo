package com.qetch.effectivejava.item3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class Elvis {
	private int age = 0;
	public static final Elvis INSTANCE = new Elvis();
	
	private Elvis() {}
	
	public void leaveTheBuilding() {}
	
	public static void main(String[] args) {
		Elvis e1 = Elvis.INSTANCE;
		Elvis e2 = Elvis.INSTANCE;
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1 == e2);
		
		Field[] fields = e1.getClass().getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		try {
			System.out.println(e1.age);
			fields[0].setInt(e1, 2);
			System.out.println(e1.age);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
