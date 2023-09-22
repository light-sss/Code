package com.light.code.kamacoder;

import java.util.Scanner;

/**
 * @author light
 * @Description 网格路径和
 *
 * 现有一个 m * n的网格，每个网格上都有一个非零整数，每次只能向下或者向右移动一格，
 * 计算从左上开始移动到右下的所有路径上数字的最大和。
 *
 * （思路：动规
 * m*n--->n行m列
 * @create 2023-08-24 10:04
 */
public class n7 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String arrayString = input.next();
		int[][] grid = parse2dArray(arrayString);

		System.out.println(getMaxValue(grid));

	}

	private static int getMaxValue(int[][] grid) {
		int m=grid.length; //行
		int n=grid[0].length;  //列
		int[][] dp=new int[m][n];  //dp[i][j]代表了从左上角到达格子(i, j)位置的最大路径和。
		//初始化dp[0][0]
		dp[0][0]=grid[0][0];
		//初始化第0列
		for (int i = 1; i < m; i++) {
			dp[i][0]=dp[i-1][0]+grid[i][0];
		}
		//初始化第0行
		for (int i = 1; i < n; i++) {
			dp[0][i]=dp[0][i-1]+grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}

	// 将字符串解析为二维数组
	private static int[][] parse2dArray(String arrayString) {
		String[] rowsString=arrayString.substring(1,arrayString.length()-2).split("],");
		// "[[1,2,3],[2,3,4],[3,4,5]]" -> "[1,2,3", "[2,3,4", "[3,4,5"
		int rows=rowsString.length; //行
		int cols=rowsString[0].split(",").length; //列
		int[][] digital2dArray = new int[rows][cols];
		for (int i = 0; i < rows; i++) {

			String[] element=rowsString[i].substring(1).split(",");
			//"[1,2,3"->1 2 3
			//"[2,3,4"->2 3 4
			//"[3,4,5"->3 4 5
			for (int j = 0; j < cols; j++) {
				digital2dArray[i][j]=Integer.parseInt(element[j]);
			}

		}

		return digital2dArray;
	}
}
