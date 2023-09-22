package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author light
 * @Description 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * @create 2023-08-16 16:58
 */
public class MinDepthTest {
	public static void main(String[] args) {
		Integer[] arr={3,9,20,null,null,15,7};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		System.out.println(minDepth(tree2.root));
	}
	public static int minDepth(TreeNode root) {
		Deque<TreeNode> que=new ArrayDeque<>();
		int depth=0;
		if(root!=null){
			que.offer(root);
			depth++;
		}
		while(!que.isEmpty()){
			int size=que.size();
			while(size>0){
				TreeNode node=que.poll();
				if(node.left==null&&node.right==null){
					return depth;
				}
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
