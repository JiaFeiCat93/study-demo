package com.qetch.designpattern.templatemethod.v2;

public class TemplateMethodMainTest2 {

	public static void main(String[] args) {
		// 模板方法模式：父类定义程序执行流程，子类实现部分步骤
		ConcreteClass1 template1 = new ConcreteClass1();
		template1.templateMethod();
		
		System.out.println("-------------------");
		
		// 更换第二个子类，程序执行流程不变
		ConcreteClass2 template2 = new ConcreteClass2();
		template2.templateMethod();
	}
}
