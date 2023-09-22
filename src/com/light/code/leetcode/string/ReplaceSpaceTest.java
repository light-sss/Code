package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 替换空格
 * 请实现一个函数，把字符串s中的每个空格替换成"%20"。
 *
 * @create 2023-08-03 11:05
 */
public class ReplaceSpaceTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		/*
		1.next()方法只会读取输入中的一个单词(以空格为分隔符)，并将其作为字符串返回。
		2.nextLine()方法会读取整行输入，并将其作为字符串返回。
		 */
		String s=input.nextLine();
		s=replaceSpace(s);
		System.out.println(s);
	}
	public static String replaceSpace(String s) {
		if(s==null||s.length()==0){
			return s;
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' '){
				sb.append("%20");
			}else{
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
