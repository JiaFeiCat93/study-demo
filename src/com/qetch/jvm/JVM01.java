package com.qetch.jvm;

import java.util.ArrayList;
import java.util.List;

public class JVM01 {
	byte[] b = new byte[1*1024*1024];//声明一个b成员变量，占用1M内存
	
	public static void main(String[] args) {
		List<JVM01> list = new ArrayList<>();
		
		try {
			while (true) {
				list.add(new JVM01());//此处有可能发生堆内存溢出的问题
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-----------");
		}
	}
}

//VM arguments（虚拟机参数）
//-Xms1m -Xmx8m 									设置堆的初始化内存为1M，运行时最大内存为8M
//-Xms1m -Xmx8m -XX:+PrintGCDetails  				设置堆的初始化内存为1M，运行时最大内存为8M，并打印GC日志
//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError   	设置堆的初始化内存为1M，运行时最大内存为8M，并导出堆内存溢出的信息文件（hprof文件）