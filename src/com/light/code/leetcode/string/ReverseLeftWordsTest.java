package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @create 2023-08-03 13:08
 */
public class ReverseLeftWordsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		int k=input.nextInt();
		s=reverseLeftWords(s,k);
		System.out.println(s);

	}
	public static String reverseLeftWords(String s, int n) {
		//在原有字符串上操作
		char[] arr=s.toCharArray();
		//先反转前n个字符
		reverse(arr,0,n-1);
		//在反转后半部分字符
		reverse(arr,n,arr.length-1);
		//最后反转整个字符
		reverse(arr,0,arr.length-1);
		return new String(arr);
	}
	public static void  reverse(char[] arr,int start,int end){
		while(start<end){
			char temp=arr[end];
			arr[end]=arr[start];
			arr[start]=temp;
			end--;
			start++;
		}
	}
}
