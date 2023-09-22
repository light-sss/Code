package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 *
 * (思路：如果把 子集问题、组合问题、分割问题都抽象为一棵树的话，
 * 那么组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点！
 *
 * 其实子集也是一种组合问题，因为它的集合是无序的，子集{1,2} 和 子集{2,1}是一样的。
 * @create 2023-08-29 10:25
 */
public class SubsetsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> res=new ArrayList<>();
	public static List<Integer> path=new ArrayList<>();
	public static List<List<Integer>> subsets(int[] nums) {
		backtracking(nums,0);
		return res;
	}

	private static void backtracking(int[] nums, int startIndex) {
		res.add(new ArrayList<>(path));//收集子集,要放在终止添加的上面,否则会漏掉自己
		//终止条件
		if(startIndex>=nums.length){
			return;
		}
		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtracking(nums,i+1);
			//回溯
			path.remove(path.size()-1);
		}
	}
}
