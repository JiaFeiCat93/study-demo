package com.qetch.funning.polymorphic;

public class ABCDMainTest {
	
	public static void main(String[] args) {
		A a1 = new A();// a1实际可以调用的方法有：show(D obj)（自己的）、show(A obj)（自己的）
		A a2 = new B();// a2实际可以调用的方法有：show(D obj)（自己的）、show(A obj)（自己的）
		B b = new B();// b实际可以调用的方法有：show(B obj)（自己的）、show(A obj)（重写的）、show(D obj)（继承父类A的）
		C c = new C();
		D d = new D();
		
		System.out.println(a1.show(b));// A and A
		System.out.println(a1.show(c));// A and A
		System.out.println(a1.show(d));// A and D
		System.out.println(a2.show(b));// B and A
		System.out.println(a2.show(c));// B and A
		System.out.println(a2.show(d));// A and D
		System.out.println(b.show(b));// B and B
		System.out.println(b.show(c));// B and B
		System.out.println(b.show(d));// A and D
	}
}

class A {
	public String show(D obj) {
		return "A and D";
	}
	
	public String show(A obj) {
		return "A and A";
	}
}

class B extends A {
	public String show(B obj) {
		return "B and B";
	}
	
	public String show(A obj) {
		return "B and A";
	}
}

class C extends B {
	
}

class D extends B {
	
}