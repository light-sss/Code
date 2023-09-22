package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 跳跃游戏
 *
 * 给你一个非负整数数组 nums，你最初位于数组的第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * (思路：问题关键不在到底跳跃几步，而是在于跳跃的覆盖范围，
 * 那个这个问题就转化为覆盖范围能否覆盖终点
 * 每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
 * 贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），
 * 整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
 * @create 2023-09-05 10:09
 */
public class CanJumpTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		if(nums.length==1){
			return true;
		}
		int coverRang=0; //记录覆盖范围---记录的是下标值
		for (int i = 0; i <=coverRang; i++) {
			coverRang=Math.max(coverRang,i+nums[i]);
			if (coverRang>=nums.length-1){
				return true;
			}
		}
		return false;
	}
}
