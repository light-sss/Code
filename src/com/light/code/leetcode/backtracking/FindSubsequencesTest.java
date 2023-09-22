package com.light.code.leetcode.backtracking;

import java.util.*;

/**
 * @author light
 * @Description 递增子序列
 *
 * 给你一个整数数组 nums ,找出并返回所有该数组中不同的递增子序列，递增子序列中至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * @create 2023-08-29 15:01
 */
public class FindSubsequencesTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(findSubsequences(nums));
	}
	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();
	public static List<List<Integer>> findSubsequences(int[] nums) {
		backtracking(nums,0);
		return res;
	}

	private static void backtracking(int[] nums, int startIndex) {
		if(path.size()>1){
			res.add(new ArrayList<>(path));  //注意不要加return，要收集树上的所有节点
		}
		if(startIndex>=nums.length){
			return;
		}
		Set<Integer> set=new HashSet<>();//记录本层元素是否重复使用
		for (int i = startIndex; i < nums.length; i++) {
			//如果队列不为空，但要添加的元素小于path中的最后一个元素---不是递增的---不满足条件
			//或者集合中已经含有nums[i]---本层有重复元素----不满足条件
			if((!path.isEmpty()&&nums[i]<path.get(path.size()-1))||set.contains(nums[i])){
				continue;
			}
			set.add(nums[i]); //每层都创建一个---不需要回溯
			path.add(nums[i]);
			backtracking(nums,i+1);
			//回溯
			path.remove(path.size()-1);
		}

	}
}
