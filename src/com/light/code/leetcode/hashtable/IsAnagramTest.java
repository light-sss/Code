package com.light.code.leetcode.hashtable;

import java.util.Scanner;

/**
 * @author light
 * @Description 有效字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @create 2023-08-01 13:52
 */
public class IsAnagramTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String str1=input.next();
		String str2=input.next();
		boolean res=isAnagram(str1,str2);
		System.out.println(res);
	}
	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()){
			return false;
		}
		int[] nums=new int[26];
		for (int i = 0; i < s.length(); i++) {
			nums[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			nums[t.charAt(i)-'a']--;
			if(nums[t.charAt(i)-'a']<0){
				return false;
			}
		}
		return true;
	}
}
