package com.light.code.leetcode.dp;

/**
 * @author light
 * @Description 零钱兑换II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * （思路：转化为完全背包问题
 * @create 2023-09-26 11:45
 */
public class ChangeTest {
	public int change(int amount, int[] coins) {
		//dp[j]:凑成总金额为j的硬币组合数为dp[j]
		int[] dp=new int[amount+1];
		dp[0]=1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <=amount; j++) {
				dp[j]+=dp[j-coins[i]];
			}

		}
		return dp[amount];

	}
}
