package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 最后一块石头的重量
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * (思路：尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。
 * @create 2023-09-21 15:03
 */
public class LastStoneWeightIITest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n= input.nextInt();
		int[] stones=new int[n];
		for (int i = 0; i < n; i++) {
			stones[i]=input.nextInt();
		}
		System.out.println(lastStoneWeightII(stones));
	}
	public static int lastStoneWeightII(int[] stones) {
		int sum=0;
		for (int n : stones) {
			sum += n;
		}
		int target = sum / 2;
		//dp[i][j]含义：任选[0-i] 个石头，装入容量为j的背包中，背包的最大重量为dp[i][j]
		int[][] dp=new int[stones.length][target+1];
		for (int i = 0; i < stones.length; i++) {
			dp[i][0]=0;
		}
		for (int i = 0; i <=target; i++) {
			if(i>=stones[0]){
				dp[0][i]=stones[0];
			}
		}
		for (int i = 1; i < stones.length; i++) {
			for (int j = 1; j <=target; j++) {
				if(j>=stones[i]){
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
				}else {
					dp[i][j]=dp[i-1][j];
				}

			}
		}
		return sum-dp[stones.length-1][target]-dp[stones.length-1][target];
	}
}
