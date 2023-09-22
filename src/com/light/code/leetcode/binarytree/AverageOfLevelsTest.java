package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description 二叉树的层平均值
 * @create 2023-08-15 18:23
 */
public class AverageOfLevelsTest {
	public static void main(String[] args) {
		Integer[] arr={3,9,20,null,null,15,7};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		List<Double> res=averageOfLevels(tree2.root);
		System.out.println(res);
	}
	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> list=new ArrayList<>();
		Deque<TreeNode> que=new ArrayDeque<>();
		if(root==null){
			return list;
		}
		que.offer(root);
		while(!que.isEmpty()){
			int size=que.size();
			int count=size;
			long sum=0;
			double avg;
			while(size>0){
				TreeNode node=que.poll();
				sum+=node.val;
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
				size--;
				if(size==0){
					avg=sum*1.0/count;
					list.add(avg);
				}
			}
		}
		return list;
	}
}
