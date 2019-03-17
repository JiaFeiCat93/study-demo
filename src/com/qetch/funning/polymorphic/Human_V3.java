package com.qetch.funning.polymorphic;

public class Human_V3 {

	public void sleep() {
		System.out.println("Human sleep...");
	}
	
	public static void main(String[] args) {
		/**
		 * 如果父类非要调用子类扩展的方法，比如speak()方法，就只能通过向下转型来实现。
		 * 向下转型需要考虑安全性，如果父类引用的对象是父类本身，那么在向下转型的过程中是不安全的，编译不会出错，但是运行时会出现java.lang.ClassCastException错误。
		 * 它可以使用intanceof来避免出现此类错误，即能否向下转型，只有先经过向上转型的对象才能继续向下转型。
		 */
		Human_V3 human = new Male_V3();// 向上转型
		Human_V3 human2 = new Human_V3();
//		human.speak();// 编译不通过：此时需要向下转型，否则不能调用speak()方法
		Male_V3 male = (Male_V3) human;// 向下转型
		male.speak();// 可以正常调用speak()方法
		
//		Male_V3 male2 = (Male_V3) human2;
//		male2.speak();// 运行报错：java.lang.ClassCastException: com.qetch.funning.polymorphic.Human_V3 cannot be cast to com.qetch.funning.polymorphic.Male_V3
		
		if (human2 instanceof Male_V3) {// 由于human2不是Male_V3的实例，所以if判断里面的代码不会执行。
			Male_V3 male3 = (Male_V3) human2;
			male3.speak();
		}
	}
}

class Male_V3 extends Human_V3 {
	
	@Override
	public void sleep() {
		System.out.println("Male sleep...");
	}
	
	public void speak() {
		System.out.println("I am Male.");
	}
}

class Female_V3 extends Human_V3 {
	
	@Override
	public void sleep() {
		System.out.println("Female sleep...");
	}
	
	public void speak() {
		System.out.println("I am female.");
	}
}