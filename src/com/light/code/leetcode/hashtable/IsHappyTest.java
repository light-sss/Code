package com.light.code.leetcode.hashtable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author light
 * @Description 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是限循环但始终变不到1。
 * 如果这个过程结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * (题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
 * @create 2023-08-02 11:30
 */
public class IsHappyTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		boolean res=isHappy(n);
		System.out.println(res);

	}
	public static boolean isHappy(int n) {
		Set<Integer> set=new HashSet<>();
		while(n!=1&&!set.contains(n)){
			set.add(n);
			n=getNextNum(n);
		}
		return n==1;
	}

	private static int getNextNum(int n) {
		int sum=0;
		int temp;
		while(n!=0){
			temp=n%10;
			sum+=temp*temp;
			n=n/10;
		}
		return sum;
	}
}
