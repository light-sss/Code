package com.light.code.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k,同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * (采用双指针法
 * @create 2023-08-02 13:31
 */
public class ThreeSumTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i]=input.nextInt();
		}
		List<List<Integer>> list=threeSum(nums);
		System.out.println(list);
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		//先对数组进行排序
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0){
				return res;
			}
			//对a去重 (a+b+c=0)
			//因为已经排序过了，只要a前面有一样的，接下来的abc要么是和前面重复的，
			// 要么就找不到这组了。bc同理只要重复一次就重复了
			int left=i+1;
			int right= nums.length-1;
			if(i>0&&nums[i]==nums[i-1]){
				continue;
			}
			while(right>left){
				if(nums[i]+nums[left]+nums[right]>0){
					right--;
				} else if (nums[i]+nums[left]+nums[right]<0) {
					left++;
				}else{
					//找到一对三元组，将三元组加入集合中
					res.add(Arrays.asList(nums[i],nums[left],nums[right]));
					//对bc去重
					while(right>left&&nums[left]==nums[left+1]){
						left++;
					}
					while(right>left&&nums[right]==nums[right-1]){
						right--;
					}
					//找到三元组后left和right同时移动
					left++;
					right--;
				}

			}
		}
		return res;
	}
}

