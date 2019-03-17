package com.qetch.funning.polymorphic;

public class Human_V2 {
	String name = "human";
	
	public String getName() {
		return this.name;
	}
	
	public void sleep() {
		System.out.println("Human sleep...");
	}
	
	public static void main(String[] args) {
		/**
		 * 向上转型中，如果父类引用非要调用子类的属性，就需要给要调用的属性添加getter方法。
		 */
		Human_V2 human = new Male_V2();// 向上转型
		human.sleep();
		System.out.println(human.getName());
	}
}

class Male_V2 extends Human_V2 {
	String name = "male";
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public void sleep() {
		System.out.println("Male sleep...");
	}
	
	public void speak() {
		System.out.println("I am Male.");
	}
}

class Female_V2 extends Human_V2 {
	String name = "female";
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public void sleep() {
		System.out.println("Female sleep...");
	}
	
	public void speak() {
		System.out.println("I am Female.");
	}
}
