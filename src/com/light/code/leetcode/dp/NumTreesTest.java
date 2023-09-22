package com.light.code.leetcode.dp;

/**
 * @author light
 * @Description 不同的二叉搜索树
 *
 * 给你一个整数n,求恰由 n 个节点组成且节点值从 1 到 n 互不相同的二叉搜索树有多少种？
 * 返回满足题意的二叉搜索树的种数。
 * @create 2023-09-14 18:49
 */
public class NumTreesTest {
	public static void main(String[] args) {
		String s1="abc";
		String s2="abc";
		System.out.println(s1 == s2);
		System.out.println(5 * 0.1 == 0.5);
	}
	public int numTrees(int n) {
		//1 确认dp数组及其含义：dp[i]:输入【i】，共有dp[i]种不同的二叉搜索树
		//也可以理解是i个不同元素节点组成的二叉搜索树的个数为dp[i] ，都是一样的。
		//dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
		//j相当于是头结点的元素，从1遍历到i为止。
		int[] dp=new int[n+1];
		dp[0]=1;
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=i; j++) {
				dp[i]+=dp[j-1]*dp[i-j];
			}
		}
		return dp[n];
	}
}
