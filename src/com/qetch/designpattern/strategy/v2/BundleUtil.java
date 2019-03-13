package com.qetch.designpattern.strategy.v2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class BundleUtil {

	static Properties properties = new Properties();
	static {
		try {
			properties.load(new FileInputStream("src/share.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getResult(String key) {
		String result = properties.getProperty(key);
		if (result != null) {
			try {
				result = new String(result.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult("share.wechat.title"));
	}
}
