package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 反转字符串
 *
 * 输入字符串以字符数组char[]的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、
 * 使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @create 2023-08-03 9:54
 */
public class ReverseStringTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String str=input.next();
		char[] arr=str.toCharArray();
		reverseString(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	public static void reverseString(char[] s) {
		for (int i = 0; i < s.length/2; i++) {
			char temp=s[s.length-i-1];
			s[s.length-i-1]=s[i];
			s[i]=temp;
		}

	}
}
