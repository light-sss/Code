package com.light.code.leetcode.cupidity;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author light
 * @Description 分发饼干
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * (思路：1.利用大饼干尽量先去满足胃口大的小孩/2.小饼干尽量先去满足胃口小的小孩
 * @create 2023-09-04 9:39
 */
public class FindContentChildrenTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] g=new int[n]; //胃口
		for (int i = 0; i < n; i++) {
			g[i]=input.nextInt();
		}
		n=input.nextInt();
		int[] s=new int[n]; //饼干尺寸
		for (int i = 0; i < n; i++) {
			s[i]=input.nextInt();
		}
		System.out.println(findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count=0;
		int index=0;
		//小饼干尽量先去满足胃口小的小孩
		for (int i = 0; i < s.length; i++) { //先遍历饼干
			if(index<g.length&&s[i] >= g[index]){
				count++;
				index++;
			}
		}
		return count;
	}
}
