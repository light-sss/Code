package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * （思路：转化为01背包问题
 * @create 2023-09-26 10:58
 */
public class FindMaxFormTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] strs=input.next().split(",");
		int m=input.nextInt();
		int n=input.nextInt();
		System.out.println(findMaxForm(strs, m, n));
	}
	public static int findMaxForm(String[] strs, int m, int n) {
		//dp[i][j]:最多有i个0，j个1的str的最大子集长度为dp[i][j]
		int[][] dp=new int[m+1][n+1];
		int zeroNum;
		int oneNum;
		dp[0][0]=0;
		//遍历物品
		for (String str : strs) {
			zeroNum=0;
			oneNum=0;
			for (int i = 0; i <str.length(); i++) {
				char ch=str.charAt(i);
				if(ch=='0'){
					zeroNum++;
				}else {
					oneNum++;
				}
			}
			//倒叙遍历---遍历背包
			for (int i =m; i >=zeroNum ; i--) {
				for (int j = n; j >=oneNum; j--) {
					dp[i][j]=Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
				}
			}
		}
		return dp[m][n];
	}
}
