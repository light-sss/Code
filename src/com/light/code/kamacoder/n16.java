package com.light.code.kamacoder;

import java.util.Scanner;

/**
 * @author light
 * @Description 开发商购买土地
 * 在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
 *
 * 现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
 *
 * 然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
 *
 * 注意：区块不可再分。
 *
 * （思路：直接暴力模拟每一次分隔，记录最小差值
 * @create 2023-09-07 19:37
 */
public class n16 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();  //n行
		int m=input.nextInt();  //m列
		int[][] land=new int[n][m];
		int sum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				land[i][j]=input.nextInt();
				sum+=land[i][j];
			}
		}

		System.out.println(getMinDiff(land, n, m, sum));

	}

	private static int getMinDiff(int[][] land,int n,int m,int sum) {
		int aArea=0;
		int bArea;
		int diff;
		int result=Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++) { //画横线
			for (int j = 0; j < m; j++) {
				aArea+=land[i][j]; //a价值
			}
			bArea=sum-aArea;  //b价值
			diff=bArea-aArea;  //ab总价值差
			result=Math.min(result,Math.abs(diff));
		}
		aArea=0;
		for (int j = 0; j < m-1; j++) {
			for (int i = 0; i < n; i++) {
				aArea+=land[i][j];
			}
			bArea=sum-aArea;  //b价值
			diff=bArea-aArea;  //ab总价值差
			result=Math.min(result,Math.abs(diff));
		}

		return result;
	}
}
