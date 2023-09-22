package com.light.code.leetcode.hashtable;

import java.util.Scanner;

/**
 * @author light
 * @Description 赎金信
 * 给你两个字符串：ransomNote和 magazine,判断ransomNote能不能由magazine里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @create 2023-08-02 13:10
 */
public class CanConstructTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String ransomNote=input.next();
		String magazine=input.next();
		boolean res=canConstruct(ransomNote,magazine);
		System.out.println(res);
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
		if(magazine.length()<ransomNote.length()){
			return false;
		}
		int[] nums=new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			nums[magazine.charAt(i)-'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			nums[ransomNote.charAt(i)-'a']--;
			if(nums[ransomNote.charAt(i)-'a']<0){
				return false;
			}
		}
		return true;
	}
}
