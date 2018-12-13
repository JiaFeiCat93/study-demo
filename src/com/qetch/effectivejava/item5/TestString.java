package com.qetch.effectivejava.item5;

public class TestString {
	
	public static void main(String[] args) {
		
		String s1 = new String("stringette");//DO'T DO THIS
		
		String s2 = "stringette";
		
		String s3 = "stringette";
		
		System.out.println(s1 == s2);//false 
		System.out.println(s2 == s3);//true 相同字面常量的字符串可以被重用
	}
}
