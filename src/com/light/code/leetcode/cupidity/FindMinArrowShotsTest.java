package com.light.code.leetcode.cupidity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author light
 * @Description 452. 用最少数量的箭引爆气球
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小弓箭数 。
 *
 * （思路：重叠在一起的气球用一只箭射出，
 * 但要注意重叠的右区间：如果下一个气球的左边界小于上一个重叠区间最小的右边界，则这个气球可以被同一只箭引爆
 * @create 2023-09-09 8:25
 */
public class FindMinArrowShotsTest {
	public static void main(String[] args) {
		int[][] points={{10,6},{2,8},{1,6},{7,12}};
		System.out.println(findMinArrowShots(points));

	}
	public static int findMinArrowShots(int[][] points) {
		//先将气球按最左区间从小到大排序
		//int 范围为-2147483648——2147483647，测试案例中会溢出
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//return o1[0]-o2[0];
				return Integer.compare(o1[0],o2[0]); //采用Integer.compare()不会溢出
			}
		});
		int count=1; //气球不为空则至少需要一只箭
		for (int i = 1; i < points.length; i++) {
			if(points[i][0]>points[i-1][1]){
				count++;
			}else {
				points[i][1]=Math.min(points[i][1],points[i-1][1]);
			}
		}

		return count;
	}
}
