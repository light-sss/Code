package com.light.code.leetcode.array;

import java.util.Scanner;

/**
 * @author light
 * @Description 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数s,找出该数组中满足其和 ≥ s的
 * 长度最小的续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * @create 2023-07-21 19:48
 */
public class MinSubArrayLenTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		int target=input.nextInt();
		//暴力解法
		int res1 = minSubArrayLen1(nums, target);
		System.out.println(res1);
		//滑动窗口解法
		int res2 = minSubArrayLen2(nums, target);
		System.out.println(res2);
	}

	private static int minSubArrayLen2(int[] nums,int target) {
		int sum=0;
		int result=Integer.MAX_VALUE;
		int subLength=0;
		for (int i = 0; i < nums.length; i++) {
			sum=0;
			for(int j=i;j<nums.length;j++){
				sum+=nums[j];
				if(sum>=target){
					subLength=j-i+1;
					result=result>subLength?subLength:result;
					break;
				}
			}
		}
		return result==Integer.MAX_VALUE?0:result;
	}

	private static int minSubArrayLen1(int[] nums,int target) {
		int left=0;
		int sum=0;
		int result=Integer.MAX_VALUE;
		for(int right=0;right<nums.length;right++){
			sum+=nums[right];
			while(sum>=target){
				result=Math.min(result,right-left+1);
				sum-=nums[left++];
			}
		}
		return result==Integer.MAX_VALUE?0:result;
	}
}
