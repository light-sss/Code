package com.light.code.kamacoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 岛屿数量
 *
 * 题目描述
 * 给定一个 m 行 n 的二维地图，初始化每个单元格都是海洋，二维地图外也全是海洋。
 *
 * 操作 addLand 会将单元格（col, row）变为陆地。定义一系列相连的被海洋包围的陆地为岛屿，
 * 横向相邻或者纵向相连的岛屿才算相连（斜着相邻的不算）。
 *
 * 现有一系列的 addLand 操作，给出每次 addLand 操作后岛屿的个数。
 * @create 2023-08-31 19:08
 */
public class n12 {
	public static Scanner input=new Scanner(System.in);

	public static void main(String[] args) {
		int m=input.nextInt(); //m行
		int n=input.nextInt(); //n列
		int k=input.nextInt(); //操作次数
		getLandCount(m,n,k);

	}

	private static void getLandCount(int m, int n, int k) {
		int[][] arr=new int[m][n];
		int count=0;
		List<Integer> list=new ArrayList<>();
		while(k--!=0){
			int row=input.nextInt();
			int col=input.nextInt();
			if(row<0||col<0||row>=m||col>=n){
				list.add(count);
				continue;
			}
			arr[row][col]=1;

			System.out.println(count);
		}
	}



}
