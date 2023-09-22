package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author light
 * @Description 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
 * @create 2023-08-14 12:56
 */
public class InvertTreeTest {
	public static void main(String[] args) {
		Integer[] data= {4,2,7,1,3,6,9};
		BinaryTree2 tree=new BinaryTree2(data);
		tree.root=invertTree(tree.root);

	}

	//递归
	public static TreeNode invertTree(TreeNode root) {
		if(root==null){
			return root;
		}
		swap(root); //中
		invertTree(root.left);  //左
		invertTree(root.right); //右
		return root;
	}

	//层序遍历
	public static TreeNode invertTree2(TreeNode root) {
		Deque<TreeNode> que=new ArrayDeque<>();
		if(root!=null){
			que.offer(root);
		}
		while(!que.isEmpty()){
			int size=que.size();
			while(size>0){
				TreeNode node=que.poll();
				swap(node);
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
				size--;
			}
		}
		return root;
	}

	private static void swap(TreeNode root) {
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
	}

}
