package com.light.code.leetcode.dp;

/**
 * @author light
 * @Description 组合总和IV
 * 你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 * 请注意，顺序不同的序列被视作不同的组合。---相当于求排列
 * （思路：转化为完全背包问题，对于排列问题，先遍历背包，在遍历物品
 * @create 2023-09-26 12:23
 */
public class CombinationSum4Test {

	public int combinationSum4(int[] nums, int target) {
		//dp[j]:总和为j的背包的元素排列个数为dp[j]
		int[] dp=new int[target+1];
		dp[0]=1;
		for (int i = 0; i <=target ; i++) { //先背包
			for (int j = 0; j < nums.length; j++) { //在物品
				if(i>=nums[j]){
					dp[i]+=dp[i-nums[j]];
				}
			}
		}
		return dp[target];
	}
}
