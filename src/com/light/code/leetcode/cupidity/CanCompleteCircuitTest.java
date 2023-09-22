package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 加油站
 *
 * 在一条环路上有n个加油站，其中第 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第i个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，
 * 则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * （思路--贪心：
 * 从第i个站点开始，如果剩余油量和<0,则从第i+1个站点开始从新作为起点开始计算
 *
 * @create 2023-09-06 8:24
 */
public class CanCompleteCircuitTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] gas=new int[n];  //汽油
		for (int i = 0; i < n; i++) {
			gas[i]=input.nextInt();
		}
		int[] cost=new int[n]; //消耗汽油
		for (int i = 0; i < n; i++) {
			cost[i]=input.nextInt();
		}

		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		/*
		暴力解法：直接模拟）遍历每一个加油站为起点的情况，模拟一圈。
		如果跑了一圈，中途没有断油，而且最后油量大于等于0，说明这个起点是ok的。

		for (int i = 0; i < gas.length; i++) {
			int rest=gas[i]-cost[i];  //剩余油量
			int index=(i+1)% gas.length;
			while(rest>0&&index!=i){ //模拟以i为起点，行驶一圈
				rest+=gas[index]-cost[index];
				index=(index+1)% gas.length;  //控制下标变化
			}
			if(rest>=0&&index==i){
				return i;//回到起始位置，如果剩余油量等于0，则返回下标
			}
		}
		return -1;

		 */
		//贪心
		int curSum=0; //统计每个站点剩余油量（累加
		int index=0;
		int totalSum=0;
		for (int i = 0; i < gas.length; i++) {
			curSum+=gas[i]-cost[i];
			totalSum+=gas[i]-cost[i];
			if(curSum<0){
				index=(i+1)% gas.length;
				curSum=0;
			}
		}
		if(totalSum<0){
			return -1;
		}else {
			return index;
		}

	}
}
