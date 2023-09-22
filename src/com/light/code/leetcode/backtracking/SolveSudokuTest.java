package com.light.code.leetcode.backtracking;

/**
 * @author light
 * @Description 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 *
 * @create 2023-08-30 12:19
 */
public class SolveSudokuTest {
	public static void solveSudoku(char[][] board) {
		backtracking(board);
	}

	private static boolean backtracking(char[][] board) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j]!='.'){
					continue;
				}else {

					for (char k = '1'; k <='9' ; k++) {
						if(isValid(i,j,k,board)){
							board[i][j]=k;
							if(backtracking(board)){
								return true;
							}
							//回溯
							board[i][j]='.';
						}
					}
					// 9个数都试完了，都不行，那么就返回false
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断棋盘是否合法有如下三个维度:
	 *     同行是否重复
	 *     同列是否重复
	 *     9宫格里是否重复
	 */
	private static boolean isValid(int row, int col, char val,char[][] board) {
		//同行是否重复
		for (int i = 0; i < 9; i++) {
			if(board[row][i]==val){
				return false;
			}
		}

		//同列是否重复
		for (int i = 0; i <9; i++) {
			if(board[i][col]==val){
				return false;
			}
		}

		//9宫格里是否重复
		int startRow=(row/3)*3;
		int startCol=(col/3)*3;
		for (int i = startRow; i <startRow+3 ; i++) {
			for (int j = startCol; j < startCol+3; j++) {
				if(board[i][j]==val){
					return false;
				}
			}
		}
		return true;
	}
}
