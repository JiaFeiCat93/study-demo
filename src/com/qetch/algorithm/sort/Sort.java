package com.qetch.algorithm.sort;

import java.util.Arrays;

public class Sort {
	
	public static void main(String[] args) {
		int[] a = new int[] {38,65,97,76,13,27,49};
		System.out.println("排序前：" + Arrays.toString(a));
		
//		selectSort(a);
//		insertSort(a);
		bubbleSort(a);
		
		System.out.println("排序后：" + Arrays.toString(a));
	}
	
	/**
	 * 选择排序
	 */
	public static void selectSort(int[] a) {
		int temp = 0;
		int flag = 0;
		int len = a.length;
		for (int i = 0; i < len; i++) {
			temp = a[i];
			flag = i;
			for (int j = i + 1; j < len; j++) { // 通过遍历i+1到最后一个元素，找出最小的
				if (a[j] < temp) {
					temp = a[j];
					flag = j;
				}
			}
			if (flag != i) { // 然后跟第i个元素交换值
				a[flag] = a[i];
				a[i] = temp;
			}
		}
	}
	
	/**
	 * 插入排序
	 */
	public static void insertSort(int[] a) {
		int len = a.length;
		int temp;
		for (int i = 1; i < len; i++) {
			temp = a[i];
			int j = i;
			if (a[j - 1] > temp) {
				while (j >= 1 && a[j - 1] > temp) {
					a[j] = a[j - 1];
					j--;
				}
			}
			a[j] = temp;
		}
	}
	
	/**
	 * 冒泡排序
	 */
	public static void bubbleSort(int[] a) {
		int len = a.length;
		int temp;
		for (int i = 0; i < len; i++) {
			for (int j = len - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}
	
	public static void mergeSort() {}
	
	public static void merge() {
		
	}
}
