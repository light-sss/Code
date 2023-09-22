package com.light.code.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author light
 * @Description 两数之和
 *
 * 给定一个整数数组nums和一个整数目标值 target,请你在该数组中找出和为
 * 目标值target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 什么时候使用哈希法：需要查询一个元素是否出现过，或一个元素是否在集合里的时候，需要考虑哈希法
 * @create 2023-08-02 11:58
 */
public class TwoSumTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i]=input.nextInt();
		}
		int target=input.nextInt();
		int[] res=twoSum(nums,target);
		System.out.println(Arrays.toString(res));

	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map=new HashMap<>();
		int[] res=new int[2];
		int temp;
		for (int i = 0; i < nums.length; i++) {
			temp=target-nums[i];
			if(map.containsKey(temp)){
				res[0]=i;
				res[1]=map.get(temp);
			}
			//key:数组元素值；value：数组元素下标
			map.put(nums[i],i);
		}
		return res;
	}
}
