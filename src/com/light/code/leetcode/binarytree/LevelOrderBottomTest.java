package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.*;

/**
 * @author light
 * @Description 二叉树的层序遍历II
 *
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 *(借助队列
 * @create 2023-08-15 17:35
 */
public class LevelOrderBottomTest {
	public static void main(String[] args) {
		Integer[] arr={3,9,20,null,null,15,7};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		List<List<Integer>> res=levelOrderBottom(tree2.root);
		System.out.println(res);
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		Deque<TreeNode> que=new ArrayDeque<>();
		if(root==null){
			return result;
		}
		que.offer(root);
		while(!que.isEmpty()){
			List<Integer> list=new ArrayList<>();
			int size=que.size();
			while(size>0){
				TreeNode node=que.poll();
				list.add(node.val);
				if(node.left!=null){
					que.add(node.left);
				}
				if(node.right!=null){
					que.add(node.right);
				}
				size--;
			}
			result.add(list);
		}
		Collections.reverse(result);
		return result;
	}

}
