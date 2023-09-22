package com.light.code.kamacoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 大鱼吃小鱼
 *
 * 现在有 N 条鱼，每条鱼的体积为 Ai，从左到右排成一排。
 *
 * A 数组是一个排列。定义一次大鱼吃小鱼的操作为：对于每一条鱼，它在每一次操作时都会吃掉右边比自己小的一条鱼，
 * 值得注意的是，在同一次操作中，每条鱼吃掉比自己小的鱼是同时发生的。
 *
 * 举例：假设有三条鱼，体积分别为 [5, 4, 3]，在一次操作中，4 吃 3，5 吃 4，最终只剩下 [5] 一条鱼。
 * 问题是，在多少次操作之后，鱼的数量就不会变了。
 *
 * (思路：
 * 判断该数组是否是递增数组,如果不是递增数组，则代表发生一次大鱼吃小鱼操作
 * 从后向前遍历数组，当前一个数值大于当前数值时，将数值删掉，直到数组递增数组为止
 * @create 2023-08-24 10:00
 */
public class n5 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		List<Integer> list=new ArrayList<>(); //利用list，方便元素删除操作
		for (int i = 0; i <n; i++) {
			list.add(input.nextInt());
		}
		int count=0; //记录大鱼吃小鱼的操作数
		while(!isIncrease(list)){
			for(int i=list.size()-1;i>0;i--){
				if(list.get(i)<list.get(i-1)){
					list.remove(i);

				}
			}
			count++;
		}
		System.out.println(count);
	}

	//判断是否为递增的
	private static boolean isIncrease(List<Integer> list) {
		for (int i =1; i < list.size(); i++) {
			if(list.get(i)<list.get(i-1)){
				return false;
			}
		}
		return true;
	}
}
