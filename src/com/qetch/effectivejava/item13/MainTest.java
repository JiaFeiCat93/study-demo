package com.qetch.effectivejava.item13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainTest {
	// Potential security hole!
	public static final Thing[] VALUES = { new Thing(), new Thing() };
	
	// Correction method 1
	private static final Thing[] PRIVATE_VALUES = { new Thing(), new Thing() };
	public static final List<Thing> VALUES2 = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
	
	// Correction method 2
	private static final Thing[] PRIVATE_VALUES2 = { new Thing(), new Thing() };
	public static final Thing[] values() {
		return PRIVATE_VALUES2;
	}
}

class Thing {}
