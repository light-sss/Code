package com.light.code.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author light
 * @Description 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * @create 2023-08-01 17:34
 */
public class IntersectionTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums1=new int[n];
		int m=input.nextInt();
		int[] nums2=new int[m];
		for (int i = 0; i < n; i++) {
			nums1[i]=input.nextInt();
		}
		for (int i = 0; i < m; i++) {
			nums2[i]=input.nextInt();
		}
		int[] res=intersection(nums1,nums2);
		System.out.println(Arrays.toString(res));
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set=new HashSet<>();
		Set<Integer> res=new HashSet<>();
		for(int num:nums1){
			set.add(num);
		}
		for(int num:nums2){
			if(set.contains(num)){
				res.add(num);
			}
		}
		int[] arr=new int[res.size()];
		int i=0;
		for(int num:res){
			arr[i++]=num;
		}
		return arr;
	}
}
