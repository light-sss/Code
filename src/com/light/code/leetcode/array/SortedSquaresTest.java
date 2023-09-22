package com.light.code.leetcode.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author light
 * @Description 有序数组的平方
 *
 * 给你一个按非递减顺序排序的整数数组 nums，
 * 返回每个数字的平方组成的新数组，要求也按递减顺序排序。
 *
 * 采用双指针解法
 * @create 2023-07-21 19:26
 */
public class SortedSquaresTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];

		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		int[] res=sortedSquares(nums);
		System.out.println(Arrays.toString(res));

	}

	private static int[] sortedSquares(int[] nums) {
		int left=0;
		int right=nums.length-1;
		int flag=nums.length-1;
		int[] res=new int[nums.length];
		while(left<=right){
			if(nums[left]*nums[left]>nums[right]*nums[right]){
				res[flag--]=nums[left]*nums[left];
				left++;
			} else if (nums[left]*nums[left]<=nums[right]*nums[right]) {
				res[flag--]=nums[right]*nums[right];
				right--;
			}
		}
		return res;
	}
}
