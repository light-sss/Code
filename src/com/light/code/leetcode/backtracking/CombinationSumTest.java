package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 组合总和
 *
 * 给你一个无重复元素的整数数组candidates和一个目标整数 target ，
 * 找出candidates中可以使数字和为目标数 target的所有不同组合 ，并以列表形式返回。
 * 你可以按任意顺序返回这些组合。
 *
 * candidates中的同一个数字可以无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * @create 2023-08-27 15:58
 */
public class CombinationSumTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] candidates=new int[n];
		for (int i = 0; i < n; i++) {
			candidates[i]=input.nextInt();
		}
		int target= input.nextInt();
		System.out.println(combinationSum(candidates, target));

	}

	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		backtracking(candidates,target,0,0);
		return res;
	}

	private static void backtracking(int[] candidates, int target, int sum, int startIndex) {
		if(sum==target){
			res.add(new ArrayList<>(path));
			return;
		}
		if(sum>target){
			return;
		}
		for (int i = startIndex; i < candidates.length; i++) {
			path.add(candidates[i]);
			sum+=candidates[i];
			backtracking(candidates,target,sum,i);
			path.remove(path.size()-1);
			sum-=candidates[i];
		}
	}
}
