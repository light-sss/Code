package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。
 * @create 2023-08-27 12:15
 */
public class LetterCombinationsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String digits=input.next();
		System.out.println(letterCombinations(digits));
	}
	public static List<String> list=new ArrayList<>();
	public static List<String> letterCombinations(String digits) {
		if(digits==null||digits.length()==0){
			return list;
		}
		//初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
		String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		backtracking(digits,numString,0);
		return list;
	}
	public static StringBuilder sb=new StringBuilder();

	private static void backtracking(String digits, String[] numString, int num) {
		if(num==digits.length()){
			list.add(sb.toString());
			return;
		}
		String string=numString[digits.charAt(num)-'0'];
		for (int i = 0; i <string.length() ; i++) {
			sb.append(string.charAt(i));
			backtracking(digits,numString,num+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}