package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @create 2023-08-30 9:36
 */
public class PermuteTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(permute(nums));
	}
	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();
	public static List<List<Integer>> permute(int[] nums) {
		int[] used=new int[nums.length]; //记录数组中哪个元素已经使用过了
		Arrays.fill(used,0);
		backtracking(nums,used);
		return res;
	}

	private static void backtracking(int[] nums,int[] used) {
		if(path.size()==nums.length){
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(used[i]==0){
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
