package com.qetch.funning.polymorphic;

/**
 * 向上转型
 * @author ZCW
 *
 */
public class Human_V1 {
	
	public void sleep() {
		System.out.println("Human sleep...");
	}
	
	public static void main(String[] args) {
		/**
		 * 向上转型：子类对象转为父类，父类可以是接口。公式：Father f = new Son();Father是父类或者接口，Son是子类或者是实现类。
		 * 注意：向上转型不要强制转型。向上转型后，父类的引用所指向的属性是父类的属性，如果子类重写了父类的方法，那么父类引用指向的或者调用的方法是子类的方法，
		 * 这个叫动态绑定。向上转型后，父类引用不能调用子类的自己的方法，就是父类没有但是子类有的方法，如果调用，则不能编译通过，比如Male类的speak()。
		 * 向下转型：父类对象转为子类。公式：Son s = (Son) f;
		 */
		Human_V1 human = new Male();// 向上转型
		human.sleep();
//		human.speak();// 报错：The method speak() is undefined for the type Human_V1
		System.out.println("-----------------");
		Male male = new Male();
		male.sleep();
		male.speak();
	}
}

class Male extends Human_V1 {
	
	@Override
	public void sleep() {
		System.out.println("Male sleep...");
	}
	
	public void speak() {
		System.out.println("I am Male.");
	}
}

class Female extends Human_V1 {
	
	@Override
	public void sleep() {
		System.out.println("Female sleep...");
	}
	
	public void speak() {
		System.out.println("I am Female.");
	}
}
