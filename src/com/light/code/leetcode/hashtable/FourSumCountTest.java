package com.light.code.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author light
 * @Description 四数相加 II
 *
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * @create 2023-08-02 12:30
 */
public class FourSumCountTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums1=new int[n];
		int[] nums2=new int[n];
		int[] nums3=new int[n];
		int[] nums4=new int[n];
		for (int i = 0; i < nums1.length; i++) {
			nums1[i]=input.nextInt();
		}
		for (int i = 0; i < nums2.length; i++) {
			nums2[i]=input.nextInt();
		}
		for (int i = 0; i < nums3.length; i++) {
			nums3[i]=input.nextInt();
		}
		for (int i = 0; i < nums4.length; i++) {
			nums4[i]=input.nextInt();
		}
		int res=fourSumCount(nums1,nums2,nums3,nums4);
		System.out.println(res);
	}
	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer,Integer> map=new HashMap<>();
		int count=0;
		int temp1;
		int temp2;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				temp1=nums1[i]+nums2[j];
				map.put(temp1,map.getOrDefault(temp1,0)+1);
			}
		}
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				temp2=0-(nums3[i]+nums4[j]);
				if(map.containsKey(temp2)){
					count+=map.get(temp2);
				}
			}
		}
		return count;
	}
}
