package com.qetch.effectivejava.item3;

public class Singleton_V2 {//����ʽ����
	private static Singleton_V2 INSTANCE;
	
	private Singleton_V2() {}//��������Ϊ˽�У����Է�ֹ�ⲿ���ô�������
	
	public static synchronized Singleton_V2 getInstance() {//synchronized�汾
		if (INSTANCE == null) {
			INSTANCE = new Singleton_V2();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V2 s1 = Singleton_V2.getInstance();
		Singleton_V2 s2 = Singleton_V2.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
