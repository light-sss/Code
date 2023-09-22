package com.light.code.leetcode.dp;

import java.util.Scanner;

/**
 * @author light
 * @Description 斐波那契数列
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1,给定 n ，请计算 F(n) 。
 * @create 2023-09-13 9:28
 */
public class FibTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		System.out.println(fib(n));
	}
	public static int fib(int n) {
		if(n<=1){
			return n;
		}
		int[] dp=new int[n+1]; //第i个斐波那契数是dp[i]
		dp[0]=0;dp[1]=1;
		for (int i = 2; i <=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
}
