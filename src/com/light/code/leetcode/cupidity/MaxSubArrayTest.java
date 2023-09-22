package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 最大子数组和
 *
 * 给你一个整数数组 nums,请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * (思路：当连续和为负数的时候抛弃当前元素，从下一个元素开始重新计算连续和
 * @create 2023-09-04 11:24
 */
public class MaxSubArrayTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(maxSubArray(nums));
	}
	public static int maxSubArray(int[] nums) {
		int count=0;
		int sum=Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			count+=nums[i];
			sum=Math.max(sum,count);
			if(count<=0){
				count=0;
			}
		}
		return sum;
	}
}
