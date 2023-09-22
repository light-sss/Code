package com.light.code.leetcode.cupidity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author light
 * @Description 合并区间
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，
 * 该数组需恰好覆盖输入中的所有区间 。
 *
 *
 * @create 2023-09-10 13:17
 */
public class MergeTest {
	public static void main(String[] args) {
		int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
		merge(intervals);


	}
	public static int[][] merge(int[][] intervals) {
		List<int[]> list=new ArrayList<>();
		//将数组按左边界排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0],o2[0]);
			}
		});
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0]<=intervals[i-1][1]){
				//有重叠，合并区间---求右边界最大值,左区间最小值
				intervals[i][1]=Math.max(intervals[i-1][1],intervals[i][1]);
				intervals[i][0]=Math.min(intervals[i-1][0],intervals[i][0]);
			}else {
				list.add(intervals[i-1]);
			}
		}
		list.add(intervals[intervals.length-1]);
		return list.toArray(new int[list.size()][]);
	}
}
