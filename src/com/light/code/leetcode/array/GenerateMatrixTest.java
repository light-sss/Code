package com.light.code.leetcode.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author light
 * @Description 螺旋矩阵II
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出: [[ 1, 2, 3 ],
 * 		 [ 8, 9, 4 ],
 *       [ 7, 6, 5 ]]
 * @create 2023-07-23 11:40
 */
public class GenerateMatrixTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[][] res = generateMatrix(n);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}

	public static int[][] generateMatrix(int n) {
		int[][] nums=new int[n][n];
		int loop=0;
		int start=0;
		int offSet=1;
		int i,j;
		int count=1;
		while(loop<n/2){
			//从左到右
			for(j=start;j<n-offSet;j++) {
				nums[start][j] = count++;
			}
			//从上到下
			for(i=start;i<n-offSet;i++){
				nums[i][j]=count++;
			}
			//从右到左
			for(;j>start;j--){
				nums[i][j]=count++;
			}
			//从下到上
			for(;i>start;i--){
				nums[i][j]=count++;
			}
			loop++;
			start++;
			offSet++;
		}
		//n为奇数
		if(n%2==1){
			nums[n/2][n/2]=n*n;
		}

		return nums;
	}
}
