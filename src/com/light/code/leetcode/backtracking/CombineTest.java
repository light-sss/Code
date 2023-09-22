package com.light.code.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author light
 * @Description 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * @create 2023-08-27 10:50
 */
public class CombineTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n= input.nextInt();
		int k= input.nextInt();
		System.out.println(combine(n, k));
	}
	public  static List<List<Integer>> res=new ArrayList<>(); //存放结果集
	public  static List<Integer> path=new ArrayList<>();  //存放路径变量
	public static List<List<Integer>> combine(int n, int k) {
		backtracking(n,k,1);

		return res;
	}

	//startIndex:记录每层递归数组起始位置---防止数组元素重复---组合
	private static void backtracking(int n, int k, int startIndex) {
		if(path.size()==k){
			res.add(new ArrayList<>(path));
			return;
		}
		//剪枝操作：可以剪枝的地方就在递归中每一层的for循环所选择的起始位置。
		//如果for循环选择的起始位置之后的元素个数已经不足我们需要的元素个数了，那么就没有必要搜索了。
		/*
		接下来看一下优化过程如下：
		已经选择的元素个数：path.size();
		还需要的元素个数为: k - path.size();
		在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
		为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
		 */
		for (int i = startIndex; i <= n-(k- path.size())+1; i++) {
			path.add(i);
			backtracking(n,k,i+1);
			//回溯
			path.remove(path.size()-1);
		}
	}
}
