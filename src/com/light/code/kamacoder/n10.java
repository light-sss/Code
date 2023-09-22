package com.light.code.kamacoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 求和
 *
 * 输入两个整数n, m，从数列 1, 2, ..., n 中随意取几个数字，
 * 使其和等于 m，要求将所有的可能的组合列出来
 * @create 2023-08-31 19:06
 */
public class n10 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int m=input.nextInt();
		getResult(m, n);

	}

	
	public static List<Integer> path=new ArrayList<>();
	public static void getResult(int m,int n){
		backtracking(m,n,0,1);
	}

	private static void backtracking(int m, int n,int sum, int startIndex) {
		if(sum>m){
			return;
		}
		if(sum==m){
			for (int i = 0; i < path.size()-1; i++) {
				System.out.print(path.get(i)+" ");
			}
			System.out.println(path.get(path.size() - 1));

		}
		for (int i = startIndex; i <=n&&sum+i<=m; i++) {
			path.add(i);
			sum+=i;
			backtracking(m,n,sum,i+1);
			path.remove(path.size()-1);
			sum-=i;
		}

	}
}
