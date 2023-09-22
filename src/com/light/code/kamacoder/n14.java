package com.light.code.kamacoder;

import java.util.Scanner;

/**
 * @author light
 * @Description 汽水瓶换饮料
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，
 * 允许向老板借空汽水瓶（只能借一个，必须要归还）。
 *
 * 小张手上有 n 个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 *
 * （思路：递归
 * f(1)=0;
 * f(2)=1;
 * f(3)=1;
 * f(4)=f(2)+1;---四个瓶子，可以用三个空瓶子换一瓶汽水，喝完后问老板借一个空瓶子，则一共可以兑换两个空瓶子
 * f(n)=f(n-2)+1;
 * @create 2023-09-07 19:05
 */
public class n14 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n;
		while((n=input.nextInt())!=0){
			System.out.println(change(n));
		}
	}

	private static int change(int n) {
		if(n==1){
			return 0;
		}
		if(n==2){
			return 1;
		}
		return change(n-2)+1;
	}
}
