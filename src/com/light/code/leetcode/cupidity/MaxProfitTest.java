package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 股票买卖最佳时机II
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。
 * 你也可以先购买，然后在同一天出售。
 *
 * 返回 你能获得的最大利润 。
 *
 * (思路：把利润拆解成以每天的维度
 * 如：第2天买入第4天卖出： price[4]-price[2]=price[4]-price[3]+price[3]-price[2]
 *
 * 贪心：获取正利润已达到全局最大利润
 * @create 2023-09-05 9:52
 */
public class MaxProfitTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(maxProfit(nums));
	}

	public static int maxProfit(int[] prices) {
		int result=0;
		for (int i = 1; i < prices.length; i++) {
			result+=Math.max(prices[i]-prices[i-1],0); //只获取正利润
		}
		return result;
	}
}
