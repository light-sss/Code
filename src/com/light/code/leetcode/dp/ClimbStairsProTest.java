package com.light.code.leetcode.dp;

/**
 * @author light
 * @Description 爬楼梯进阶版
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 升级：
 * 改为：一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。
 * 问有多少种不同的方法可以爬到楼顶呢？
 *
 * （思路：
 * 1阶，2阶，.... m阶就是物品，楼顶就是背包。
 *
 * 每一阶可以重复使用，例如跳了1阶，还可以继续跳1阶。
 *
 * 问跳到楼顶有几种方法其实就是问装满背包有几种方法。
 *
 *这就是一个完全背包问题了
 * @create 2023-09-26 14:54
 */
public class ClimbStairsProTest {
	public int climbStairs(int n,int m) {
		//dp[i]:爬到第i阶楼梯共有dp[i]种方法
		int[] dp=new int[n+1];
		dp[0]=1;
		for (int i = 1; i <=n ; i++) { //先背包
			for (int j = 1; j <=m; j++) { //再物品
				if(i>=j){
					dp[i]+=dp[i-j];
				}
			}
		}
		return dp[n];
	}
}
