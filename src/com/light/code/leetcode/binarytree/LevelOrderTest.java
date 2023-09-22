package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的层序遍历 。
 * （即逐层地，从左到右访问所有节点）。
 *
 * (利用队列
 * @create 2023-08-15 14:17
 */
public class LevelOrderTest {
	public static void main(String[] args) {
		Integer[] arr={3,9,20,null,null,15,7};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		List<List<Integer>> res=levelOrder(tree2.root);
		System.out.println("迭代");
		System.out.println(res);
		System.out.println("递归");
		List<List<Integer>> res1=levelOrder2(tree2.root);
		System.out.println(res1);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		Deque<TreeNode> que=new ArrayDeque<>(); //队列
		if(root==null){
			return result;
		}
		que.offer(root);
		while(!que.isEmpty()){
			List<Integer> list=new ArrayList<>();
			int size=que.size();
			while(size>0){
				TreeNode node = que.poll();
				list.add(node.val);
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
				size--;
			}
			result.add(list);
		}
		return result;
	}
	public static List<List<Integer>> l=new ArrayList<>();

	public static List<List<Integer>> levelOrder2(TreeNode root) {
		checkFun(root,0);
		return l;
	}

	public static void checkFun(TreeNode root,int deep){
		if(root==null){
			return ;
		}
		deep++;

		if(l.size()<deep){
			List<Integer> item=new ArrayList<>();
			l.add(item);
		}

		l.get(deep-1).add(root.val);
		checkFun(root.left,deep);
		checkFun(root.right,deep);

	}
}
