package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，
 * 每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 思路：
 * 其实在遍历字符串的过程中，只要让 i += (2 * k)，i 每次移动 2 * k 就可以了，然后判断是否需要有反转的区间。
 *
 * 因为要找的也就是每2 * k 区间的起点，这样写，程序会高效很多。
 *
 * 所以当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。
 * @create 2023-08-03 10:32
 */
public class ReverseStrTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		int k=input.nextInt();
		String str=reverseStr(s,k);
		System.out.println(str);
	}
	public static String reverseStr(String s, int k) {
		char[] arr=s.toCharArray();
		for (int i = 0; i < arr.length; i+=(2*k)) {
			if(i+k<=arr.length){
				//1.每隔2k个字符反转前k个
				//2.剩余字符小于2k但大于或等于k个,反转前k个字符
				int end=i+k-1;
				reverse(arr,i,end);
			}else{
				//3.剩余字符不足k个，将剩余字符全部反转
				reverse(arr,i,arr.length-1);
			}
		}
		return new String(arr);
	}
	//自定义反转函数
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
