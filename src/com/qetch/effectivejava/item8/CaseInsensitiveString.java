package com.qetch.effectivejava.item8;

public final class CaseInsensitiveString {
	private final String s;
	
	public CaseInsensitiveString(String s) {
		if (s == null) {
			throw new NullPointerException();
		}
		this.s = s;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CaseInsensitiveString) {
			return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
		}
		
		if (obj instanceof String) {
			return s.equalsIgnoreCase((String) obj);
		}
		return false;
	}
	
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("polish");
		String s = "polish";
		System.out.println(cis.equals(s));//true
		System.out.println(s.equals(cis));//false
	}
}
