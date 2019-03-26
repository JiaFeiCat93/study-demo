package com.qetch.algorithm.sort;

import java.util.Arrays;

public class Sort {
	
	public static void main(String[] args) {
		int[] a = new int[] {2,4,1,8,3,7,5,9};
		System.out.println("排序前：" + Arrays.toString(a));
		insertSort(a);
		System.out.println("排序后：" + Arrays.toString(a));
	}
	
	public static void insertSort(int[] a) {
		int len = a.length;
		int insertNum;
		for (int i = 0; i < len; i++) {
			insertNum = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > insertNum) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = insertNum;
		}
	}
}
