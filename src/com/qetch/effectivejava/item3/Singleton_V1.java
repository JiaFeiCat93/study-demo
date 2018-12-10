package com.qetch.effectivejava.item3;

public class Singleton_V1 {//����ʽ����
	private static Singleton_V1 INSTANCE;
	
	private Singleton_V1() {}//��������Ϊ˽�У����Է�ֹ�ⲿ���ô�������
	
	public static Singleton_V1 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton_V1();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V1 s1 = Singleton_V1.getInstance();
		Singleton_V1 s2 = Singleton_V1.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
