package com.light.code.leetcode.stack_queue;

import java.util.*;

/**
 * @author light
 * @Description 前k个高频元素
 *
 * 给你一个整数数组 nums和一个整数k,请你返回其中出现频率前k高的元素。
 * 你可以按任意顺序返回答案。
 *
 *（利用小顶堆，堆中只维护k个元素
 * @create 2023-08-12 15:55
 */
public class TopKFrequentTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		int k=input.nextInt();
		int[] res=topKFrequent(nums,k);
		System.out.println(Arrays.toString(res));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		//key:元素；value：元素所出现的频率
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],map.getOrDefault(nums[i],0)+1);
		}
		//按小顶堆排序（从小到大排
		PriorityQueue<Integer> que=new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1)-map.get(o2);
			}
		});
		for (Integer key:map.keySet()){
			if(que.size()<k){
				que.add(key);
			}else if(map.get(key)>map.get(que.peek())){
				que.poll();
				que.add(key);
			}
		}
		int[] res=new int[k];
		for (int i = 0; i < res.length; i++) {
			res[i]=que.poll();
		}

		return res;
	}
}
