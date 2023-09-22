package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description N皇后
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题研究的是如何将 n个皇后放置在n×n的棋盘上,并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题的棋子放置方案，
 * 该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @create 2023-08-30 11:13
 */
public class SolveNQueensTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		System.out.println(solveNQueens(n));
	}


	public static List<List<String>> res=new ArrayList<>();

	public static List<List<String>> solveNQueens(int n) {
		char[][] chessboard = new char[n][n];
		for (char[] c : chessboard) {
			Arrays.fill(c, '.');
		}
		backtracking(chessboard,n,0);
		return res;
	}

	//row:行--控制递归深度
	private static void backtracking(char[][] chessboard, int n, int row) {
		//终止条件--收获结果
		if(row==n){
			res.add(arrayToList(chessboard));
			return;
		}
		//单层递归逻辑
		for (int col = 0; col < n; col++) {
			//判断是否合法位置
			if(isValid(chessboard,row,col,n)){
				chessboard[row][col]='Q';
				backtracking(chessboard,n,row+1);
				//回溯
				chessboard[row][col]='.';
			}
		}
	}

	private static List<String> arrayToList(char[][] chessboard) {
		List<String> path=new ArrayList<>();
		for (int i = 0; i < chessboard.length; i++) {
			path.add(String.valueOf(chessboard[i]));
		}
		return path;
	}

	/*
	验证棋盘是否合法
		按照如下标准去重：
			1.不能同行
			2.不能同列
			3.不能同斜线 （45度和135度角）
	 */
	private static boolean isValid(char[][] chessboard, int row, int col, int n) {
		////检查行  （可以不用检查行，每一次递归，row+1
		//for (int i = 0; i < col; i++) {
		//	if(chessboard[row][i]=='Q'){
		//		return false;
		//	}
		//}

		//检查列
		for (int i = 0; i < row; i++) {
			if(chessboard[i][col]=='Q'){
				return  false;
			}
		}

		//检查斜线--45度
		for (int i = row-1,j=col-1; i>=0&&j>=0 ; i--,j--) {
			if(chessboard[i][j]=='Q'){
				return  false;
			}
		}

		//检查斜线--135度
		for (int i = row-1,j=col+1; i >=0&&j<n ; i--,j++) {
			if(chessboard[i][j]=='Q'){
				return false;
			}
		}

		return true;

	}

}
