package com.light.code.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author light
 * @Description 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（
 * 如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * @create 2023-08-01 18:04
 */
public class IntersectTest {
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
		int[] res=intersect(nums1,nums2);
		System.out.println(Arrays.toString(res));
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int num:nums1){
			map.put(num,map.getOrDefault(num,0)+1);
		}
		int[] res=new int[nums1.length];
		int i=0;
		for(int num:nums2){
			if(map.containsKey(num)&&map.get(num)>0){
				res[i++]=num;
				map.put(num,map.get(num)-1);
			}
		}
		return Arrays.copyOfRange(res,0,i);
	}
}
