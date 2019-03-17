package com.qetch.funning.polymorphic;

/**
 * 向上转型和向下转型总结：
 * 1.把子类对象直接赋给父类引用，叫upcasting向上转型，向上转型不用强制转型。如Father father = new Son();
 * 2.把指向子类对象的父类引用，赋给子类引用，叫downcasting向下转型，要强制转型。要向下转型，必须先向上转型，为了安全，可以用instanceof判断。
 * 		如上面例子中的father就是一个指向子类对象的父类引用，把father赋给子类引用son，即Son son = (Son) father;
 * 		其中father前面的(Son)必须添加，进行强制转换。
 * 3.upcasting会丢失子类特有的方法，但是子类overriding父类的方法，子类方法有效，向上转型只能引用父类对象的属性，要引用子类对象属性，则要写getter()方法。
 * 4.向上转型的作用，是可以减少重复代码。父类为参数，调用时用子类对象作为参数，就是利用了向上转型。这样使代码变得简洁，体现了JAVA的抽象变成思想。
 */
public class Human_V4 {
	
	public void sleep() {
		System.out.println("Human sleep...");
	}
	
	public static void doSleep(Human_V4 human) {
		human.sleep();
	}
	
	public static void main(String[] args) {
		Human_V4 human = new Male_V4();// 向上转型
		doSleep(human);
		doSleep(new Male_V4());// 此处匿名子类对象，当然实际应用时应该是用上面的向上转型公式，然后将子类对象传递进来，这样以后好再向下转型，此处没有向下转型，所以直接使用了匿名类对象。
		doSleep(new Female_V4());
	}
}

class Male_V4 extends Human_V4 {
	
	@Override
	public void sleep() {
		System.out.println("Male sleep...");
	}
}

class Female_V4 extends Human_V4 {
	
	@Override
	public void sleep() {
		System.out.println("Female sleep...");
	}
}
