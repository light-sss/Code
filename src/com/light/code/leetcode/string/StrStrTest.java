package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 找出字符串中第一个匹配项的下标(实现strStr()函数
 *
 * 给你两个字符串haystack和needle请你在haystack字符串中找出needle字符串
 * 的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，
 * 则返回  -1 。
 *
 * （kmp算法：当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内部，
 * 			 利用这些信息避免从头再去做匹配
 * 		本质：在当前文本串和模式串检索过程中，若出现了不匹配，如何充分利用已经匹配的部分
 * @create 2023-08-03 20:53
 */
public class StrStrTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String haystack =input.next();
		String needle =input.next();
		int res = strStr(haystack, needle);
		System.out.println(res);

	}
	public static int strStr(String haystack, String needle) {
		int[] next=new int[needle.length()];
		/*获取next数组（前缀表
		next数组：用来回退的，他记录了模式串中与主串不皮牌的时候，模式串应该从哪里开始重新匹配
		 */
		getNext(next,needle);
		int j=0;
		for (int i = 0; i < haystack.length(); i++) {
			while (j>0&&haystack.charAt(i)!=needle.charAt(j)){
				j=next[j-1];
			}
			if(haystack.charAt(i)==needle.charAt(j)){
				j++;
			}
			if(j==needle.length()){
				return i-needle.length()+1;
			}
		}

		return -1;
	}

	public static void getNext(int[] next,String needle){
		/*1.初始化:
			j:前缀末尾位置（并且是i(包括i)之前的最长相等前后缀长度
			i:后缀末尾位置
			初始化next数组
		 */
		int j=0;
		next[0]=0;
		for (int i = 1; i <needle.length() ; i++) {
			//2.前后缀不相等
			while(j>0&&needle.charAt(i)!=needle.charAt(j)){
				j=next[j-1];
			}
			//3.前后缀相等
			if(needle.charAt(i)==needle.charAt(j)){
				j++;
			}
			//4.为next数组赋值
			next[i]=j;
		}

	}
}
