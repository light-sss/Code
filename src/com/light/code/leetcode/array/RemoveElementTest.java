package com.light.code.leetcode.array;

import java.util.Scanner;

/**
 * @author light
 * @Description 移除元素:
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 采取快慢指针法：
 * 快指针用于查找新元素数组内容
 * 慢指针用于更新数组下标
 *
 * @create 2023-07-17 20:59
 */
public class RemoveElementTest {
	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<nums.length;i++){
			nums[i]=input.nextInt();
		}
		int target=input.nextInt();

		int res = RemoveElement(nums,target);
		System.out.println(res);

	}

	private static int RemoveElement(int[] nums,int target) {
		int slowIndex=0;
		for(int fastIndex=0;fastIndex<nums.length;fastIndex++){
			if(nums[fastIndex]!=target){
				nums[slowIndex++]=nums[fastIndex];
			}
		}
		return slowIndex;
	}
}
