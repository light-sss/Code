package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），
 * 并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 * @create 2023-09-14 18:19
 */
public class IntegerBreakTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		System.out.println(integerBreak(n));
	}
	public static int integerBreak(int n) {
		int[] dp=new int[n+1]; //dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
		dp[2]=1;
		for (int i = 2; i <=n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(j*(i-j))));
			}
		}
		return dp[n];
	}
}
