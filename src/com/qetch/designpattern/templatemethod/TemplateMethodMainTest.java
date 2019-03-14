package com.qetch.designpattern.templatemethod;

public class TemplateMethodMainTest {

	public static void main(String[] args) {
		CreamCake creamCake = new CreamCake();
		creamCake.makeCake();
		System.out.println("-------------------");
		CheeseCake cheeseCake = new CheeseCake();
		cheeseCake.makeCake();
		System.out.println("-------------------");
		MousseCake mousseCake = new MousseCake();
		mousseCake.makeCake();
		System.out.println("-------------------");
		SmallCake smallCake = new SmallCake();
		smallCake.makeCake();
	}
}
