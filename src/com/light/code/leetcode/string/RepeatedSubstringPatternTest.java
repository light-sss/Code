package com.light.code.leetcode.string;

import java.util.Scanner;

/**
 * @author light
 * @Description 重复的子字符串
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @create 2023-08-11 1:40
 */
public class RepeatedSubstringPatternTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s =input.next();
		boolean res = repeatedSubstringPattern(s);
		System.out.println(res);
	}
	public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		for (int i = 1; i * 2 <= n; ++i) {
			if (n % i == 0) {
				boolean match = true;
				for (int j = i; j < n; ++j) {
					if (s.charAt(j) != s.charAt(j - i)) {
						match = false;
						break;
					}
				}
				if (match) {
					return true;
				}
			}
		}
		return false;
	}

}
