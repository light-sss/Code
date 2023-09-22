package com.light.code.leetcode.cupidity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 划分字母区间
 *
 * (思路:遍历字符串，找到每个字符的最远下标
 * @create 2023-09-10 11:07
 */
public class PartitionLabelsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		System.out.println(partitionLabels(s));
	}

	public static List<Integer> partitionLabels(String s) {
		List<Integer> list=new ArrayList<>(); //定义结果集
		int[] edge=new int[27]; //存放元素最远下标
		char[] arr=s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			edge[arr[i]-'a']=i;
		}
		int idx=0;
		int end=0;
		for (int i = 0; i < arr.length; i++) {
			idx=Math.max(idx,edge[arr[i]-'a']); //找到最远下标
			if(i==idx){
				list.add(idx-end+1); //将长度加入集合中
				end=i+1;
			}
		}
		return list;
	}
}
