package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 柠檬水找零
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
 * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * (思路：有三种情况
 * 1.账单是5，直接收下
 * 2.账单是10，先消耗5，在增加10
 * 3.账单是20，优先消耗10，在消耗5（贪心，美元5更万能
 * @create 2023-09-06 10:25
 */
public class LemonadeChangeTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] bills=new int[n];
		for (int i = 0; i < n; i++) {
			bills[i]=input.nextInt();
		}
		System.out.println(lemonadeChange(bills));
	}
	public static boolean lemonadeChange(int[] bills) {
		int five=0,ten=0,twenty=0;
		for (int bill : bills) {
			if(bill==5){
				five++;
			}
			if(bill==10){
				if(five<=0){
					return false;
				}
				five--;
				ten++;
			}
			if(bill==20){
				if(five>0&&ten>0){
					ten--;
					five--;
					twenty++;
				}else if(five>=3){
					five-=3;
					twenty++;
				}else {
					return false;
				}
			}
		}
		return true;
	}
}
