package com.qetch.effectivejava.item1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
	private Services() {}
	
	private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
	
	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	public static void registerDefaultProvider(Provider provider) {
		registerProvider(DEFAULT_PROVIDER_NAME, provider);
	}
	
	public static void registerProvider(String name, Provider provider) {
		providers.put(name, provider);
	}
	
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static Service newInstance(String name) {
		Provider provider = providers.get(name);
		if (provider == null) {
			throw new IllegalArgumentException("No provider registered with name: " + name);
		}
		return provider.newService();
	}
}
