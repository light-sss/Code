package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 反转字符串中的单词
 *
 * 给你一个字符串 s ，请你反转字符串中单词的顺序。
 * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
 * 返回单词顺序颠倒且单词之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * @create 2023-08-03 11:39
 */
public class ReverseWordsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		/*
		1.next()方法只会读取输入中的一个单词(以空格为分隔符)，并将其作为字符串返回。
		2.nextLine()方法会读取整行输入，并将其作为字符串返回。
		 */
		String s=input.nextLine();
		s=reverseWords(s);
		System.out.println(s);

	}
	public static String reverseWords(String s) {
		char[] arr=s.toCharArray();
		//1.去掉字符串中首尾及中间多余空格
		arr=removeExtraSpaces(arr);
		//System.out.println("去除多余空格后：");
		//for (int i = 0; i < arr.length; i++) {
		//	System.out.print(arr[i]);
		//}
		//2.将字符串全部反转
		reverseStr(arr,0,arr.length-1);
		//System.out.println("\n全部反转后：");
		//for (int i = 0; i < arr.length; i++) {
		//	System.out.print(arr[i]);
		//}
		//3.将字符串中单词再反转一遍
		reverseEachWord(arr);
		//System.out.println("\n反转单个单词后：");
		//for (int i = 0; i < arr.length; i++) {
		//	System.out.print(arr[i]);
		//}
		return new String(arr);
	}

	private static char[] removeExtraSpaces(char[] arr) {
		//双指针
		int slow=0;
		for (int fast = 0; fast < arr.length; fast++) {
			//移除所有空格
			if(arr[fast]!=' '){
				//除了第一个单词外，所有单词中间有一个空格
				if(slow!=0){
					arr[slow]=' ';
					slow++;
				}
				while(fast<arr.length&&arr[fast]!=' '){
					arr[slow++]=arr[fast++];
				}
			}
		}
		char[] ch=new char[slow];
		//System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//src:源数组 srcPos:源数组要复制的起始位置 dest:目的数组 destPos:目的数组放置的起始位置 length:复制的长度.
		// 就是把一个数组中某一段字节数据放到另一个数组中
		System.arraycopy(arr,0,ch,0,slow);
		return ch;

	}

	private static void reverseStr(char[] arr,int start,int end) {
		while(start<end){
			char temp=arr[end];
			arr[end]=arr[start];
			arr[start]=temp;
			end--;
			start++;
		}
	}

	private static void reverseEachWord(char[] arr) {
		int start=0;
		int end=0;
		while(end<arr.length){
			while(end<arr.length&&arr[end]!=' '){
				end++;
			}
			reverseStr(arr,start,end-1);
			start=end+1;
			end=start+1;
		}
	}
}
