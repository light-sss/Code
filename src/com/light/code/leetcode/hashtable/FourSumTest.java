package com.light.code.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 四数之和
 * 给你一个由 n 个整数组成的数组 nums,和一个目标值 target.
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * (双指针
 * @create 2023-08-02 15:34
 */
public class FourSumTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i]=input.nextInt();
		}
		int target=input.nextInt();
		List<List<Integer>> res=fourSum(nums,target);
		System.out.println(res);
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		//a+b+c+d=target
		//对数组进行排序
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			//一级剪枝
			if(nums[i]>0&&nums[i]>target){
				return res;
			}
			//一级去重
			if(i>0&&nums[i]==nums[i-1]){
				continue;
			}
			for (int j = i+1; j < nums.length; j++) {
				//二级剪枝
				if(nums[i]+nums[j]>0&&nums[i]+nums[j]>target){
					break;
				}
				//二级去重
				if(j>i+1&&nums[j]==nums[j-1]){
					continue;
				}
				int left=j+1;
				int right= nums.length-1;
				while(right>left){
					long sum=(long)(nums[i]+nums[j]+nums[left]+nums[right]);
					if(sum>target){
						right--;
					} else if (sum<target) {
						left++;
					}else{
						//找到a+b+c+d=target的四元组
						res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
						//对left、right去重
						while(right>left&&nums[left]==nums[left+1]){
							left++;
						}
						while (right>left&&nums[right]==nums[right-1]){
							right--;
						}
						left++;
						right--;
					}
				}
			}

		}
		return res;
	}
}
