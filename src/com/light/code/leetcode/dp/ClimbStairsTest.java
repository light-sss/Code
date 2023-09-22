package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @create 2023-09-13 9:36
 */
public class ClimbStairsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		System.out.println(climbStairs(n));
	}
	public static int climbStairs(int n) {
		int[] dp=new int[n+1]; //爬到第i层楼梯，可以有dp[i]中方法
		dp[1]=1;dp[2]=2;
		for (int i = 3; i <=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
}
