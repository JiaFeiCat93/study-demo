package com.qetch.funning.enums;

public enum AccountType {
	SAVING, 
	FIXED, 
	CURRENT;
	private AccountType() {
		System.out.println("It is a account type");
	}
}

class EnumOne {
	public static void main(String[] args) {
		System.out.println(AccountType.FIXED);
		
		/**
		 * result，枚举类AccountType在初始化时，会调用3次构造方法来初始化它的3个元素；初始化完毕后，以后每次调用调用元素，都不再调用构造方法
		 */
//		It is a account type
//		It is a account type
//		It is a account type
//		FIXED
	}
}
