package com.qetch.funning.java8.lambda;

/**
 * lambda表达式的重要特征：
 * 1.可选类型说明：不需要声明参数类型，编译器可以统一识别参数值。
 * 2.可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 3.可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 4.可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值。
 * 
 * 简单例子：
 * 1.不需要参数，返回值为5
 * () -> 5
 * 2.接收一个参数（数字类型），返回其2倍的值
 * x -> 2 * x
 * 3.接收两个参数（数字类型），并返回它们的差值
 * (x, y) -> x - y
 * 4.接收两个int参数，返回它们的和
 * (int x, int y) -> x + y
 * 5.接收一个string对象，并在控制台打印，不返回任何值
 * (String s) -> System.out.print(s)
 * @author ZCW
 *
 */
public class Java8Tester {
	
	// 标记了final的外层局部变量
	static final String salutation = "Hello!";
	
	public static void main(String[] args) {
		Java8Tester tester = new Java8Tester();
		
		// 参数类型声明
		MathOperation addition = (int a, int b) -> a + b;
		
		// 不用参数类型声明
		MathOperation substraction = (a, b) -> a - b;
		
		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {return a * b;};
		
		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, substraction));
		System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		
		// 不用括号
		GreetingService greetingService1 = message -> 
		System.out.println("Hello " + message);
		
		// 使用括号
		GreetingService greetingService2 = (message) ->
		System.out.println("Hello " + message);
		
		greetingService1.sayMessage("Runoob");
		greetingService2.sayMessage("Google");
		
		// lambda表达式只能引用标记了final的外层局部变量，这就是说不能在lambda表达式内部修改定义在域外的局部变量，否则会编译错误
		GreetingService greetingService3 = message ->
		System.out.println(salutation + message);
		greetingService3.sayMessage("Runoob");
		
//		final int num = 1;
		int num = 1;
		Convertor<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
		s.convert(2); // 输出结果为 3
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
	
	interface Convertor<T1, T2> {
		void convert(int i);
	}
}