package com.qetch.jvm;

import java.util.ArrayList;
import java.util.List;

public class JVM01 {
	byte[] b = new byte[1*1024*1024];//����һ��b��Ա������ռ��1M�ڴ�
	
	public static void main(String[] args) {
		List<JVM01> list = new ArrayList<>();
		
		try {
			while (true) {
				list.add(new JVM01());//�˴��п��ܷ������ڴ����������
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-----------");
		}
	}
}

//VM arguments�������������
//-Xms1m -Xmx8m 									���öѵĳ�ʼ���ڴ�Ϊ1M������ʱ����ڴ�Ϊ8M
//-Xms1m -Xmx8m -XX:+PrintGCDetails  				���öѵĳ�ʼ���ڴ�Ϊ1M������ʱ����ڴ�Ϊ8M������ӡGC��־
//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError   	���öѵĳ�ʼ���ڴ�Ϊ1M������ʱ����ڴ�Ϊ8M�����������ڴ��������Ϣ�ļ���hprof�ļ���