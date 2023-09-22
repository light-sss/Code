package com.light.code.leetcode.binarytree.define_create;

/**
 * @author light
 * @Description 定义二叉树
 * @create 2023-08-13 19:33
 */
public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(Integer val){
		this.val=val;
	}
	public TreeNode(int val,TreeNode left,TreeNode right){
		this.val=val;
		this.left=left;
		this.right=right;
	}


}
