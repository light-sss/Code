package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * （思路：分解成01背包问题--背包容量为目标和
 * @create 2023-09-15 9:23
 */
public class CanPartitionTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n= input.nextInt();
		int[] num=new int[n];
		for (int i = 0; i < n; i++) {
			num[i]=input.nextInt();
		}
		System.out.println(canPartition(num));
	}
	public static boolean canPartition(int[] nums) {
		// 不能均分，直接返回false
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (sum % 2 != 0) {
			return false;
		}
		// 能均分，计算平均分
		int score = sum / 2;
		/**
		 * 回溯
		 * 	//标记数组
		 * 	boolean[] flag = new boolean[nums.length];
		 * Arrays.fill(flag, false);
		 * return helper(nums, flag, 0, score, 0);
		 *
		 */
		/**
		 * 动规：1.二维数组
		 * dp[i][j]:从[0-i]中任选，装进背包容量为j的背包，所获得的最大价值为dp[i][j]
		 *
		  int[][] dp=new int[nums.length][score+1];
		//初始化看背包容量：
		// 当背包容量为零时，背包中放不进任何一个物品--->初始化为零
		// 看物品：已经放入物品一个，若背包容量大于物品重量，背包中是物品的价值，否则--->0
		for (int i = 0; i < nums.length; i++) {
			dp[i][0]=0;
		}
		for (int i = 0; i <=score; i++) {
			if(i<nums[0]){
				dp[0][i]=0;
			}else{
				dp[0][i]=nums[0];
			}
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j <=score; j++) {
				if(j>=nums[i]){
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		if(dp[nums.length-1][score]==score){
			return true;
		}else {
			return false;
		}

		 */

		/**
		 *  动规：2.滚动数组
		 *  dp[j]:背包容量为j的背包，所能容纳的最大价值为dp[j]
		 */
		int[] dp=new int[score+1];
		dp[0]=0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = score; j>=nums[i] ; j--) {
				dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
			}
		}
		if(dp[score]==score){
			return true;
		}
		return false;


	}
	//回溯
	private  static  boolean helper(int[] nums,  boolean[] flag, int curnum, int score, int pos) {
		// 每一轮的终止条件：这一轮满足条件了，可以下一轮了
		if (curnum == score) {
			return true;
		}
		// 从头开始新的一轮，子集的累计和
		for (int i = pos; i < nums.length; i++) {
			if (flag[i]) {
				continue;
			}
			flag[i] = true;
			if(helper(nums, flag, curnum + nums[i], score, i + 1)){
				return true;
			}
			flag[i] = false;
		}
		return false;
	}
}
