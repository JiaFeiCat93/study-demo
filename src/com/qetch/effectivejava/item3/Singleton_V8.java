package com.qetch.effectivejava.item3;

import java.util.HashMap;
import java.util.Map;

public class Singleton_V8 {
	private static Map<String, Singleton_V8> map = new HashMap<>();
	
	static {
		Singleton_V8 singleton = new Singleton_V8();
		map.put(singleton.getClass().getName(), singleton);
	}
	
	private Singleton_V8() {}
	
	public static Singleton_V8 getInstance(String name) {
		if (name == null) {
			name = Singleton_V8.class.getName();
			System.out.println("name == null" + "--->name:" + name);
		}
		if (map.get(name) == null) {
			try {
				map.put(name, (Singleton_V8) Class.forName(name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return map.get(name);
	}
	
	public String about() {
		return "Hello, I am RegSingleton";
	}
	
	public static void main(String[] args) {
		Singleton_V8 s1 = Singleton_V8.getInstance(null);
		System.out.println(s1.about());
	}
	
}
