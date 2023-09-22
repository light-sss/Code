package com.light.code.leetcode.array;

import java.util.Scanner;

/**
 * @author light
 * @Description 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @create 2023-07-08 21:00
 */
public class BinarySearchTest {
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
		return -1;
	}
}
