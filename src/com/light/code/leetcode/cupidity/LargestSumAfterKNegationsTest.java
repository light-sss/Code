package com.light.code.leetcode.cupidity;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author light
 * @Description  K 次取反后最大化的数组和
 *
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * (思路：让绝对值大的负数变为正数，当前数值达到最大，整体最优：整个数组和达到最大。
 * 那么如果将负数都转变为正数了，K依然大于0，此时的问题是一个有序正整数序列，如何转变K次正负，让 数组和达到最大。
 * 那么又是一个贪心：局部最优：只找数值最小的正整数进行反转，当前数值和可以达到最大（例如正整数数组{5, 3, 1}，反转1 得到-1 比 反转5得到的-5 大多了），全局最优：整个数组和达到最大。
 *
 * 那么本题的解题步骤为：
 * 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
 * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
 * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
 * 第四步：求和
 * @create 2023-09-05 15:51
 */
public class LargestSumAfterKNegationsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		int k=input.nextInt();
		System.out.println(largestSumAfterKNegations(nums, k));
	}

	public static int largestSumAfterKNegations(int[] nums, int k) {
		//1.将数组按照绝对值大小从大到小排序
		//Integer[] integers=new Integer[nums.length];
		//for (int i = 0; i < nums.length; i++) {
		//	integers[i]=nums[i];
		//}
		//Arrays.sort(integers, new Comparator<Integer>() {
		//	@Override
		//	public int compare(Integer o1, Integer o2) {
		//		return Math.abs(o2)-Math.abs(o1);
		//	}
		//});
		nums= IntStream.of(nums)
				.boxed()
				.sorted((a,b)->Math.abs(b)-Math.abs(a))
				.mapToInt(Integer::intValue).toArray();
		//从前向后遍历，遇到负数将其变为正数，同时K--
		for (int i = 0; i < nums.length&&k>0; i++) {
			if(nums[i]<0){
				nums[i]=-nums[i];
				k--;
			}
		}

		//如果K还大于0，那么反复转变数值最小的元素，将K用完
		if(k%2==1){ //若剩余k为奇数进行更改，若k为偶数次则不进行取反
			nums[nums.length-1]=-nums[nums.length-1];
		}

		//求和
		//int sum=0;
		//for (int i = 0; i < nums.length; i++) {
		//	sum+=nums[i];
		//}
		//return sum;
		return Arrays.stream(nums).sum();
	}
}
