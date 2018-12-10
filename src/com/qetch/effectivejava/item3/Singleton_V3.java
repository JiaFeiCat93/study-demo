package com.qetch.effectivejava.item3;

public class Singleton_V3 {//����ʽ����
	private static Singleton_V3 INSTANCE;
	
	private Singleton_V3() {}//��������Ϊ˽�У����Է�ֹ�ⲿ���ô�������
	
	public static Singleton_V3 getInstance() {//˫�ؼ�飨Double-Check���汾
		if (INSTANCE == null) {
			synchronized (Singleton_V3.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton_V3();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V3 s1 = Singleton_V3.getInstance();
		Singleton_V3 s2 = Singleton_V3.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
