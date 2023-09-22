package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 子集II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 *
 *
 * @create 2023-08-29 11:03
 */
public class SubsetsWithDupTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(subsetsWithDup(nums));
	}

	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		int[] used=new int[nums.length];
		Arrays.fill(used,0);
		backtracking(nums,0,used);
		return res;
	}

	private static void backtracking(int[] nums, int startIndex, int[] used) {
		res.add(new ArrayList<>(path));
		//终止条件
		if(startIndex>=nums.length){
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if(i>0&&nums[i]==nums[i-1]&&used[i-1]==0){
				continue;
			}
			path.add(nums[i]);
			used[i]=1;
			backtracking(nums,i+1,used);
			//回溯
			path.remove(path.size()-1);
			used[i]=0;

		}

	}
}
