package com.light.code.kamacoder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author light
 * @Description 逛街
 *
 * 小明在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有 n 座高楼排成一行。
 * 小明从第一栋一直走到了最后一栋，小明从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
 * （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 *
 * (思路：
 * 题目中要求从两个方向看，从左向右遍历和从右向左遍历，考虑使用单调栈
 * 首先定义一个数组存放结果；将 visibleCounts 每个位置上的值加 1（因为包括自己本身的楼）。
 * **从左向右遍历高楼时，定义一个栈stack1,栈中存放已经经过的高楼，保证栈顶元素始终比后面元素高；
 * 遍历过程中，对于每一栋楼，将当栈中大小加到对应楼visibleCounts的下标处；表示向左看的楼数
 *
 * **从右向左遍历高楼时，定义一个栈stack2，栈中存放已经经过的高楼，保证栈顶元素始终比后面元素高；
 * 遍历过程中，对于每一个元素,将当前栈的大小加到对应楼visibleCounts的下标出，表示向右看的楼数
 * @create 2023-08-17 6:04
 */
public class n4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//String[] buildings = input.next().split(",");
		//int[] height=new int[buildings.length];
		//for (int i = 0; i < height.length; i++) {
		//	height[i]=Integer.parseInt(buildings[i]);
		//}
		String buildings=input.next();
		int[] height=parseIntArray(buildings);
		int[] visibleCounts=new int[height.length];
		Arrays.fill(visibleCounts,1); //先自加1，表示楼本身
		findVisibleCounts(height,visibleCounts);
		System.out.println(Arrays.toString(visibleCounts).replaceAll(" ",""));

	}


	public static void findVisibleCounts(int[] height,int[] visibleCounts){
		Deque<Integer> stack1=new ArrayDeque<>(); //存放从左向右遍历的楼数：表示向左看
		Deque<Integer> stack2=new ArrayDeque<>();//存放从右向左遍历的楼数：表示向右看
		for (int i = 0; i < height.length; i++) {
			visibleCounts[i]+=stack1.size();
			while(!stack1.isEmpty()&&stack1.peek()<=height[i]){
				stack1.pop();
			}
			stack1.push(height[i]);
		}

		for (int i = height.length-1; i >=0 ; i--) {
			visibleCounts[i]+=stack2.size();
			while(!stack2.isEmpty()&&stack2.peek()<=height[i]){
				stack2.pop();
			}
			stack2.push(height[i]);
		}
	}
	private static int[] parseIntArray(String buildings) {
		String[] s=buildings.substring(1,buildings.length()-1).split(",");
		int[] height=new int[s.length];
		for (int i = 0; i < height.length; i++) {
			height[i]=Integer.parseInt(s[i].trim());
		}
		return height;
	}


}
