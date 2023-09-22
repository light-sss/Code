package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 组合总和II
 * 给定一个候选人编号的集合 candidates和一个目标数target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * @create 2023-08-27 16:11
 */
public class CombinationSum2Test {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] candidates=new int[n];
		for (int i = 0; i < n; i++) {
			candidates[i]=input.nextInt();
		}
		int target= input.nextInt();
		System.out.println(combinationSum2(candidates, target));
	}
	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		int[] used=new int[candidates.length]; //判断集合重元素是否重复使用
		Arrays.fill(used,0);
		backtracking(candidates,target,0,used);
		return res;
	}

	private static void backtracking(int[] candidates, int target,int startIndex,int[] used) {
		if(target==0){
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length&&target-candidates[i]>=0; i++) {
			//要进行树层去重（横向
			if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==0){
				continue;
			}
			path.add(candidates[i]);
			target-=candidates[i];
			used[i]=1;
			backtracking(candidates,target,i+1,used);
			path.remove(path.size()-1);
			target+=candidates[i];
			used[i]=0;
		}
	}
}
