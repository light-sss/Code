package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author light
 * @Description 二叉树的最大深度(相当于二叉树的层数
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的最大深度是指从根节点到最远叶子节点的最长路径上的节点数。
 * @create 2023-08-16 16:46
 */
public class MaxDepthTest {
	public static void main(String[] args) {
		Integer[] arr={3,9,20,null,null,15,7};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		System.out.println(maxDepth(tree2.root));
	}
	public static int maxDepth(TreeNode root) {
		Deque<TreeNode> que=new ArrayDeque<>();
		if(root!=null){
			que.offer(root);
		}
		int depth=0;
		while(!que.isEmpty()){
			int size=que.size();
			while(size>0){
				TreeNode node=que.poll();
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
				size--;
				if(size==0){
					depth++;
				}
			}
		}
		return depth;
	}
}
