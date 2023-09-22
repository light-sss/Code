package com.light.code.leetcode.stack_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author light
 * @Description 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值 。
 *
 * 自定义队列：队列口中始终存放滑动窗口中的最大值
 * @create 2023-08-12 14:18
 */
public class MaxSlidingWindowTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		int k=input.nextInt();
		int[] res=maxSlidingWindow(nums,k);
		System.out.println(Arrays.toString(res));
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		MyQue que=new MyQue();
		int[] res=new int[nums.length-k+1]; //定义结果数组
		int index=0;
		for (int i = 0; i < k; i++) {
			que.add(nums[i]);
		}
		res[index++]=que.getMaxValue();
		for (int i = k; i < nums.length; i++) {
			//维持滑动窗口，保证队列头部元素是该滑动窗口的最大值
			que.pop(nums[i-k]);
			que.add(nums[i]);
			res[index++]=que.getMaxValue();
		}

		return res;
	}
}
//自定义队列
class MyQue{
	Deque<Integer> que=new LinkedList<>();

	//添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
	//保证队列元素单调递减
	//比如此时队列元素3,1;2将要入队，2比1大，所以1弹出，此时队列：3,2
	public void add(int x){
		while(!que.isEmpty()&&que.getLast()<x){
			que.removeLast();
		}
		que.add(x);
	}

	//获取滑动窗口内最大值
	public int getMaxValue(){
		return que.peek();
	}

	public void pop(int x){
		if(!que.isEmpty()&&x==que.peek()){
			que.poll();
		}
	}
}