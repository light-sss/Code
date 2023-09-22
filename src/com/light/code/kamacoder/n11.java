package com.light.code.kamacoder;

import java.util.Scanner;

/**
 * @author light
 * @Description  问题: 到达目的地的最短距离
 *
 * 在数轴上，有一个点（坐标为x）可以移动。
 *
 * 这个点遵循移动规则如下：
 *
 * 1. 在数轴上向前移动一格，即 x = x + 1
 * 2. 在数轴上向后移动一格，即 x = x - 1
 * 3. 在数轴上移动到当前位置数值的两倍：即 x = x * 2
 *
 * 现这个点在原点，求将这个点移动到位置 X 所需要的最少移动次数。
 *
 *(思路：动态规划
 *
 * @create 2023-08-31 19:08
 */
public class n11 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int x=input.nextInt();
		System.out.println(getMinDistance(x));
	}

	private static int getMinDistance(int x) {
		if ( x < 2 && x >= 0) {
			return x;
		}
		// 处理 x 为负数的情况
		if (x < 0) {
			x = -x;
		}
		//求将这个点移动到位置X所需要的最少移动次数为dp[i]。
		int[] dp=new int[x+1];
		/*
		一、如果当前的位置能够被 2 整除，只有一种走法
		    从别的位置，通过在数轴上移动到当前位置数值的两倍方式移动过来的。
		    dp[i] = dp[i / 2] + 1;

		二、如果当前的位置不能被 2 整数，有两种走法
		    1. 通过在数轴上向前移动一格的方式移动过来的
		    2. 通过在数轴上向后移动一格的方式移动过来的

		    dp[i] = Math.min(dp[i - 1], dp[(i + 1) / 2] + 1) + 1

		    第 1 种走法为 dp[i - 1] 不难理解
		    为什么第 2 种走法会是 dp[(i + 1) / 2] + 1 呢？
		    因为如果当前位置不能被整除，那么这个位置的后一个位置必定能被整除，能被整除的坐标参考能被整除的走法。
		 */
		dp[0]=0;
		dp[1]=1;
		for (int i = 2; i <=x ; i++) {
			if(i%2==0){
				dp[i]=dp[i/2]+1;
			}else {
				dp[i]=Math.min(dp[i-1],1+dp[(i+1)/2])+1;
			}
		}
		return dp[x];
	}
}
