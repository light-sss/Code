package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 单调递增的数字
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 * (思路：从后向前遍历数字，当遇到Num[i]<Num[i-1]时,只需要令Num[i]=9，Num[i-1]--即可,
 * @create 2023-09-10 13:40
 */
public class MonotoneIncreasingDigitsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		System.out.println(monotoneIncreasingDigits(n));
	}
	public static int monotoneIncreasingDigits(int n) {
		String s=String.valueOf(n);
		char[] arr=s.toCharArray();
		int flag=arr.length;
		for (int i =arr.length-1; i >0; i--) {
			if(arr[i-1]>arr[i]){
				arr[i-1]--;
				flag=i; //记录要变为9的下标起始位置
			}
		}
		for (int i = flag; i < arr.length; i++) {
			arr[i]='9';
		}
		return Integer.parseInt(String.valueOf(arr));
	}
}
