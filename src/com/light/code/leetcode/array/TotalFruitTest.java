package com.light.code.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author light
 * @Description 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，
 * 其中 fruits[i]是第 i 棵树上的水果种类 。
 *
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有两个篮子，并且每个篮子只能装单一类型的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从每棵树（包括开始采摘的树）上恰好摘一个水果。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组fruits ，返回你可以收集的水果的最大数目。
 *

 * @create 2023-07-22 17:23
 */
public class TotalFruitTest {
	public static void main(String[] args) {
		int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
		int res = totalFruit(fruits);
		System.out.println(res);
	}
	public static int totalFruit(int[] fruits) {
		int n = fruits.length;
		Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

		int left = 0, ans = 0;
		for (int right = 0; right < n; ++right) {
			cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
			while (cnt.size() > 2) {
				cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
				if (cnt.get(fruits[left]) == 0) {
					cnt.remove(fruits[left]);
				}
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;

	}
}
