package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 目标和
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *（思路：可以将数组分为两部分left和right，
 * 即有left-right=target;
 * 又有left+right=sum;
 * 转化为left=(sum+target)/2
 * 所以有两个解法---1.回溯求目标和；2.转化维持01背包问题---背包容量为left；
 * @create 2023-09-26 10:13
 */
public class FindTargetSumWaysTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n= input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		int target=input.nextInt();
		System.out.println(findTargetSumWays(nums, target));
	}
	public static int findTargetSumWays(int[] nums, int target) {
		int sum=0;
		for (int num : nums) {
			sum+=num;
		}
		if(Math.abs(target)>sum){
			return  0; //找不到组合
		}
		int left=(sum+target)/2;
		if((sum+target)%2!=0){
			return 0; //找不到组合
		}

		//动规
		//dp[j]:装满容量为j的背包共有dp[j]种方法
		int[] dp=new int[left+1];
		dp[0]=1;
		for (int i = 0; i < nums.length; i++) { //先遍历物品
			for(int j=left;j>=nums[i];j--){ //再遍历背包
				dp[j]+=dp[j-nums[i]];
			}

		}
		return dp[left];
	}
}
