package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 摆动序列
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如， [1, 7, 4, 9, 2, 5] 是一个摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 * （思路：删除单调坡度上的节点，只保留两端节点，这个坡度就有两个局部峰值
 * 考虑三种情况：
 * 1.上下坡中有平坡   1-2-2-1  删除左边的元素或删除右边的元素
 * 2.首尾元素  给最左端元素向前延伸一个值，默认最右端有摆动不列入计算
 * 3.单调坡中有平坡  1-2-2-3-4
 * @create 2023-09-04 10:17
 */
public class WiggleMaxLengthTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n]; //胃口
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(wiggleMaxLength(nums));
	}

	public static int wiggleMaxLength(int[] nums) {
		if(nums.length==1){
			return 1;
		}
		int prediff=0; //上一个差值
		int curdiff=0; //当前差值
		int result=1; //默认最右端有摆动
		for (int i = 1; i < nums.length; i++) {//不遍历最后一个元素，默认最后一个元素有摆动
			curdiff=nums[i]-nums[i-1];
			if(prediff>=0&&curdiff<0||prediff<=0&&curdiff>0){
				result++;
				prediff=curdiff; //prediff跟着curdiff去变化，但没必要实时跟着curdiff去变化，只需要当坡度有变化是去记录一下坡度的原始方向---解决情况三
			}
		}
		return result;
	}
}
