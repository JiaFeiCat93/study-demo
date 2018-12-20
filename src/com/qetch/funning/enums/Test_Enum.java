package com.qetch.funning.enums;

enum number {
	zero(0), one(1), two(2);
	int n;

	number(int i) {
		this.n = i;
	}

	public int getValue() {
		return this.n;
	}
}

interface People_State {
	String getState();

	State_Enum ChangeState();
}

enum State_Enum implements People_State {
	normal("正常"), stop("停止");
	private final String state;

	State_Enum(String s) {
		this.state = s;
	}

	public String toString() {
		return state;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public State_Enum ChangeState() {
		if (this == normal)
			return stop;
		else
			return normal;
	}
}

public class Test_Enum {
	public static void main(String[] args) {
		number z = number.zero;
		State_Enum state = State_Enum.normal;
		System.out.println(z.getValue());//0
		System.out.println(z);//zero
		System.out.println(number.one);//one
		switch (z) {
		case zero:
			System.out.println(0);//0
			break;
		case one:
			System.out.println(1);
			break;
		case two:
			System.out.println("2");
			break;
		}
		// equals
		if (z.equals(number.one)) {
			System.out.println("equal!");
		} else {
			System.out.println("unequal");//unequal
		}
		// valueOf
		System.out.println(number.valueOf("zero"));//zero
		// ordinal
		System.out.println(z.ordinal()); // the index of values  //0
		System.out.println(state.toString());//正常
		state = state.ChangeState();
		System.out.println(state.getState());//停止
		
		/**
		 * result
		 */
//		0
//		zero
//		one
//		0
//		unequal
//		zero
//		0
//		正常
//		停止
	}
}