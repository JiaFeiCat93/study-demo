package com.qetch.funning;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Properties initProp = new Properties(System.getProperties());
		System.out.println("��ǰϵͳ����:" + initProp.getProperty("file.encoding"));
		System.out.println("��ǰϵͳ����:" + initProp.getProperty("user.language"));
//		encodeError();
		encodeError2();
//		analyze();
//		gbk2Utf();
//		analyze2();
//		correctEncode();
//		correctEncode2();
	}
	
	public static void encodeError() throws UnsupportedEncodingException {  
	    String gbk = "������";  
	    String utf8 = new String(gbk.getBytes("UTF-8"));  
	  
	    //ģ��UTF-8�������վ��ʾ  
	    System.out.println(new String(utf8.getBytes(),"UTF-8"));  
	}  
	/* 
	����?? 
	*/ 
	
	public static void analyze() throws UnsupportedEncodingException {  
	    String gbk = "������";  
	    String utf8 = new String(gbk.getBytes("UTF-8"));  
	    for (byte b : gbk.getBytes("UTF-8")) {  
	        System.out.print(b + " ");  
	    }  
	    System.out.println();  
	    for (byte b : utf8.getBytes()) {  
	        System.out.print(b + " ");  
	    }  
	}  
	/* 
	-26 -120 -111 -26 -99 -91 -28 -70 -122  
	-26 -120 -111 -26 -99 -91 -28 -70 63  
	*/  
	
	public static void gbk2Utf() throws UnsupportedEncodingException {  
	    String gbk = "������";  
	    char[] c = gbk.toCharArray();  
	    byte[] fullByte = new byte[3*c.length];  
	    for (int i=0; i<c.length; i++) {  
	        String binary = Integer.toBinaryString(c[i]);  
	        StringBuffer sb = new StringBuffer();  
	        int len = 16 - binary.length();  
	        //ǰ�油��  
	        for(int j=0; j<len; j++){  
	                sb.append("0");  
	            }  
	        sb.append(binary);  
	        //����λ���ﵽ��24λ3���ֽ�  
	        sb.insert(0, "1110");  
            sb.insert(8, "10");  
            sb.insert(16, "10");  
            fullByte[i*3] = Integer.valueOf(sb.substring(0, 8), 2).byteValue();//�������ַ�����������  
            fullByte[i*3+1] = Integer.valueOf(sb.substring(8, 16), 2).byteValue();  
            fullByte[i*3+2] = Integer.valueOf(sb.substring(16, 24), 2).byteValue();  
	    }  
	    //ģ��UTF-8�������վ��ʾ  
	    System.out.println(new String(fullByte,"UTF-8"));  
	}  
	
	public static void analyze2() throws UnsupportedEncodingException {  
	    String gbk = "������";  
	    byte[] utfBytes = gbk.getBytes("UTF-8");//�õ�9���ֽ�  
	    String utf8 = new String(utfBytes);//����ͳ�����  
	    System.out.print(utf8);  
	}  
	/* 
	我来�? 
	*/  
	
	public static void encodeError2() throws UnsupportedEncodingException {  
	    String gbk = "������2011��";  
	    String utf8 = new String(gbk.getBytes("UTF-8"));  
	  
	    //ģ��UTF-8�������վ��ʾ  
	    System.out.println(new String(utf8.getBytes(),"UTF-8"));  
	}  
	/* 
	����??011?? 
	*/ 
	
	public static void correctEncode() throws UnsupportedEncodingException {  
	    String gbk = "������";  
	    String iso = new String(gbk.getBytes("UTF-8"),"ISO-8859-1");  
	    System.out.println(iso);
	    for (byte b : iso.getBytes("ISO-8859-1")) {  
	        System.out.print(b + " ");  
	    }  
	    System.out.println();  
	  
	    //ģ��UTF-8�������վ��ʾ  
	    System.out.println(new String(iso.getBytes("ISO-8859-1"),"UTF-8"));  
	}  
	/* 
	-26 -120 -111 -26 -99 -91 -28 -70 -122  
	������ 
	*/  
	
	public static void correctEncode2() throws UnsupportedEncodingException {  
	    String gbk = "������";  
	    String iso = new String(gbk.getBytes(),"ISO-8859-1");  
	    System.out.println(iso);
	    for (byte b : iso.getBytes("ISO-8859-1")) {  
	        System.out.print(b + " ");  
	    }  
	    System.out.println();  
	  
	    //ģ��UTF-8�������վ��ʾ  
	    System.out.println(new String(iso.getBytes("ISO-8859-1"), "UTF-8"));  
	} 
}
