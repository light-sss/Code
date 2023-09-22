package com.light.code.leetcode.cupidity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author light
 * @Description 无重叠区间
 *
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 *
 * @create 2023-09-10 10:41
 */
public class EraseOverlapIntervalsTest {
	public static void main(String[] args) {
		int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(intervals));
	}
	public static int eraseOverlapIntervals(int[][] intervals) {
		//先将数组按左边界排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0],o2[0]);
			}
		});
		int count=0;//记录重叠区间数
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0]<intervals[i-1][1]){ //判断重叠情况
				count++;

				intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
			}
		}
		return count;
	}
}
