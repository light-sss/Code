package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 组合总和III
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回所有可能的有效组合的列表。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * @create 2023-08-27 11:18
 */
public class CombinationSum3Test {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n= input.nextInt();
		int k= input.nextInt();
		System.out.println(combinationSum3(k, n));
	}
	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();
	public static List<List<Integer>> combinationSum3(int k, int n) {
		backtracking(k,n,1,0);
		return res;
	}

	private static void backtracking(int k, int n, int startNum,int sum) {
		if(sum>n){
			return;
		}
		if(path.size()==k){
			if(sum==n){
				res.add(new ArrayList<>(path));
			}
			return;
		}

		for (int i = startNum; i <=9-(k- path.size())+1 ; i++) {
			path.add(i);
			sum+=i;
			backtracking(k,n,i+1,sum);
			//回溯
			path.remove(path.size()-1);
			sum-=i;
		}
	}
}
