package com.light.code.leetcode.array;

import java.util.Scanner;

/**
 * @author light
 * @Description  搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * @create 2023-07-08 21:33
 */
public class SearchCaretPositionTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=input.nextInt();
		}
		int target=input.nextInt();

		int result = search(nums, target);
		System.out.println(result);


	}
	public  static int search(int[] nums,int target){
		int left=0;
		int right=nums.length-1;

		while(left<=right){
			int middle=(left+right)/2;
			if(nums[middle]==target){
				return middle;
			}else if(nums[middle]<target){
				left=middle+1;
			}else {
				right=middle-1;
			}

		}
		return right+1;
	}
}
