package com.light.code.kamacoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author light
 * @Description 子矩形的最大面积
 * 给定一个矩形，宽度为 W，高度为 H，现需要对其进行划分。
 * 现有一个数组 yCutting 用于表示在水平方向上用于切分矩形的切线位置，
 * 另有一个数组 xCutting 表示在垂直方向上用于切分矩形的切线位置。
 * 求被切割后的所有子矩形中最大的那块的面积。
 *
 *(思路：首先读取输入数据，然后对水平和垂直切割数组进行排序，并
 * 利用辅助函数 getMaxInterval 计算每个方向上切割区间的最大值。
 * 最终，将两个方向上的最大切割区间相乘即得到最大子矩形的面积。
 * @create 2023-08-17 6:03
 */
public class n3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//获取矩形高度
		int h=input.nextInt();
		//获取矩形宽度
		int w=input.nextInt();
		//yCutting 数组的长度及内容
		int y= input.nextInt();
		int[] yCutting=new int[y];
		for (int i = 0; i < y; i++) {
			yCutting[i]=input.nextInt();
		}
		//xCutting 数组的长度及内容
		int x= input.nextInt();
		int[] xCutting=new int[x];
		for (int i = 0; i < x; i++) {
			xCutting[i]=input.nextInt();
		}

		//对切割点进行排序
		Arrays.sort(yCutting);
		Arrays.sort(xCutting);

		//获取水平切割区间最大值
		int maxYInterval=getMaxInterval(yCutting,w);
		//获取垂直切割区间最大值
		int maxXInterval=getMaxInterval(xCutting,h);
		//计算最大子矩形面积
		int maxArea=maxXInterval*maxYInterval;

		System.out.println(maxArea);


	}

	private static int getMaxInterval(int[] cuttingArray, int dimension) {
		int interval=cuttingArray[0]; //获取首边界到第一条割线的距离
		for (int i = 1; i < cuttingArray.length; i++) {
			interval=Math.max(interval,cuttingArray[i]-cuttingArray[i-1]);
		}

		//dimension-cuttingArray[cuttingArray.length-1]:最后一条割线到尾边界的距离
		interval=Math.max(interval,dimension-cuttingArray[cuttingArray.length-1]);
		return interval;
	}
}
