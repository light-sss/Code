package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 全排列II
 *
 *给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * (需要去重
 * @create 2023-08-30 9:59
 */
public class PermuteUniqueTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(permuteUnique(nums));
	}

	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		int[] used=new int[nums.length]; //记录数组中哪个元素已经使用过了--同时去重
		Arrays.fill(used,0);
		backtracking(nums,used);
		return  res;
	}

	private static void backtracking(int[] nums, int[] used) {
		if(path.size()== nums.length){
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			//去重逻辑
			if(i>0&&nums[i]==nums[i-1]&&used[i-1]==0){
				continue;
			}
			if(used[i]==0){ //数组元素还未使用
				path.add(nums[i]);
				used[i]=1;
				backtracking(nums,used);
				//回溯
				path.remove(path.size()-1);
				used[i]=0;
			}
		}
	}
}
