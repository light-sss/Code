package com.light.code.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 找到字符串中所有字母异位词
 *
 * 给定两个字符串s和p,找到s中所有p的异位词的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 滑动窗口解法
 * 根据题目要求，我们需要在字符串 s 寻找字符串 p 的异位词。
 * 因为字符串 p 的异位词的长度一定与字符串 p 的长度相同，所以我们可以在字符串 s 中
 * 构造一个长度为与字符串 p 的长度相同的滑动窗口，并在滑动中维护窗口中每种字母的数量；
 * 当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/
 * 来源：力扣（LeetCode）
 * @create 2023-08-01 15:01
 */
public class FindAnagramsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		String p=input.next();
		List<Integer> list=findAnagrams(s,p);
		System.out.println(list);
	}
	public static List<Integer> findAnagrams(String s, String p) {
		if(s.length()<p.length()){
			return new ArrayList<Integer>();
		}
		int[] sCount=new int[26];
		int[] pCount=new int[26];
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i <p.length(); i++) {
			sCount[s.charAt(i)-'a']++;
			pCount[p.charAt(i)-'a']++;
		}
		if(Arrays.equals(sCount,pCount)){
			list.add(0);
		}
		for (int i = 0; i < s.length() - p.length(); i++) {
			//维护滑动窗口
			sCount[s.charAt(i)-'a']--;
			sCount[s.charAt(i+p.length())-'a']++;
			if(Arrays.equals(sCount,pCount)){
				list.add(i+1);
			}
		}
		return list;
	}
}
