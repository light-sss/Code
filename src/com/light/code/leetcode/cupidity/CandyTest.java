package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * (贪心：
 * 1.从左向右遍历，比较右边大于左边的值
 * 2.从右向左遍历，比较左边大于右边的值
 * @create 2023-09-06 10:01
 */
public class CandyTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] ratings=new int[n];
		for (int i = 0; i < n; i++) {
			ratings[i]=input.nextInt();
		}
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {
		int[] canVec=new int[ratings.length];
		canVec[0]=1;
		//从左向右遍历
		for (int i = 1; i < ratings.length; i++) {
			//if(ratings[i]>ratings[i-1]){
			//	canVec[i]=canVec[i-1]+1;
			//}else {
			//	canVec[i]=1;
			//}
			canVec[i]=(ratings[i]>ratings[i-1])?canVec[i-1]+1:1;
		}

		//从右向左遍历
		for (int i = ratings.length-2; i >=0; i--) {
			if(ratings[i]>ratings[i+1]){
				canVec[i]=Math.max(canVec[i+1]+1,canVec[i]);
			}
		}
		int sum=0;
		for (int i = 0; i < canVec.length; i++) {
			sum+=canVec[i];
		}
		return sum;
	}
}
