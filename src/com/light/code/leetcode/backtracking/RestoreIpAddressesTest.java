package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 复原IP地址
 *
 * 有效IP地址正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是有效IP地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是无效IP地址。
 * 给定一个只包含数字的字符串s,用以表示一个IP地址，返回所有可能的有效IP地址，
 * 这些地址可以通过在s中插入 '.'来形成。你不能重新排序或删除s中的任何数字。你可以按 任何 顺序返回答案。
 * @create 2023-08-28 21:21
 */
public class RestoreIpAddressesTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		System.out.println(restoreIpAddresses(s));
	}
	public static List<String> res=new ArrayList<>();
	public static List<String> restoreIpAddresses(String s) {
		if(s.length()>12){ //剪枝
			return res;
		}
		//采用StringBuilder,不用重复重复重复创建字符串
		StringBuilder sb=new StringBuilder(s);
		backtracking(sb,0,0);
		return res;
	}

	private static void backtracking(StringBuilder sb, int startIndex, int pointCount) {
		//终止条件
		if(pointCount==3){
			// 判断第四段子字符串是否合法，如果合法就放进result中
			if(isValid(sb,startIndex,sb.length()-1)){
				res.add(sb.toString());
			}
			return;
		}
		for (int i = startIndex; i < sb.length(); i++) {
			//判断字段是否合法
			if(isValid(sb,startIndex,i)){
				//如果合法添加"." sb.insert（）方法，该方法是在索引的前面添加字符串
				sb.insert(i+1,".");
				pointCount++;
				//将i+2的位置作为下一个字符串的起始位置，因为多添加了一个"."
				backtracking(sb,i+2,pointCount);
				//回溯
				sb.deleteCharAt(i+1);
				pointCount--;
			}else {
				break;
			}
		}
	}

	/*
	判断是否合法IP段：
		1.每个整数位于0到255之间组成
		2.段位以0为开头的数字不合法
		3.段位里有非正整数字符不合法
	 */
	private static boolean isValid(StringBuilder sb, int start, int end) {
		if(start>end){
			return false;
		}
		//3.段位里有非正整数字符不合法
		for (int i = start; i <=end ; i++) {
			if(sb.charAt(i)<'0'||sb.charAt(i)>'9'){
				return false;
			}
		}
		//1.每个整数位于0到255之间组成
		int num=Integer.parseInt(sb.substring(start,end+1));
		if(num<0||num>255){
			return false;
		}
		//2.段位以0为开头的数字不合法
		if(sb.charAt(start)=='0'&&start!=end){
			return false;
		}
		return true;
	}

}
