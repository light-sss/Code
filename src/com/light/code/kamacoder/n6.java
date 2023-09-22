package com.light.code.kamacoder;

import java.util.Scanner;

/**
 * @author light
 * @Description 打印二维数组
 *
 * 给定一个空的二维整型数组 array[n][m]，根据下图的填充规则填充该二维数组。
 * @create 2023-08-24 10:03
 */
public class n6 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int m=input.nextInt();
		int[][] nums=new int[n][m];
		int count=1;
		//从左到右遍历
		for (int i = 0; i <m-1; i++) {
			int x=0;
			int y=i;
			while(x!=n&&y!=-1){
				nums[x][y]=count++;
				x++;
				y--;
			}
		}

		//从上到下
		for (int i = 0; i <n ; i++) {
			int x=i;
			int y=m-1;
			while(y!=-1&&x!=n){
				nums[x][y]=count++;
				x++;
				y--;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int l = 0; l < m; l++) {
				System.out.print(nums[k][l]+" ");
			}
			System.out.println();
		}
	}
}
