package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 打印二叉树
 * @create 2023-08-14 13:06
 */
public class BinaryTreePrinter {
	public static void printTree(TreeNode root) {
		printTree(root, 0);
	}

	private static void printTree(TreeNode node, int level) {
		if (node == null) {
			return;
		}
		TreeNode cur=node;
		System.out.print(node.val+"\t");
		printTree(node.left, level + 1);
		printTree(node.right, level + 1);
	}

	public static void main(String[] args) {
		// 创建一个二叉树
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		// 打印二叉树
		printTree(root);
	}

}
