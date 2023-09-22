package com.light.code.leetcode.cupidity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author light
 * @Description 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，
 * 前面正好有 ki个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * 返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * （思路：遇到有两个维度进行判断时，一定要先确定一个维度，在确定另一个维度
 *
 * 先对身高进行排序
 * @create 2023-09-06 10:41
 */
public class ReconstructQueueTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[][] people=new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				people[i][j]=input.nextInt();
			}
		}
		people=reconstructQueue(people);
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1; j++) {
				System.out.print(people[i][j]+" ");
			}
		}
		System.out.println(people[n - 1][n - 1]);

	}
	public static int[][] reconstructQueue(int[][] people) {
		//1.现根据身高进行排序
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){
					return o1[1]-o2[1]; //如果身高相同，则将k按从小到大排序
				}
				return o2[0]-o1[0]; //将身高从大到小排序
			}
		});
		LinkedList<int[]> list=new LinkedList<>();
		for (int[] p : people) {
			list.add(p[1],p);    //Linkedlist.add(index, value)，会將value插入到指定index里。
		}
		return list.toArray(new int[people.length][]);
	}
}
