package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 平衡二叉树
 * @create 2023-08-18 16:02
 */
public class IsBalancedTest {
	public static void main(String[] args) {
		Integer[] arr = {3,9,20,null,null,15,7};
		BinaryTree2 tree=new BinaryTree2(arr); //按数组方式创建二叉树
		System.out.println(isBalanced(tree.root));
	}

	public static boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		return getHeight(root)!=-1?true:false;
	}

	private static int getHeight(TreeNode root) {
		if(root==null){
			return 0;
		}
		int left=getHeight(root.left);
		if(left==-1){
			return -1;
		}
		int right=getHeight(root.right);
		if(right==-1){
			return  -1;
		}
		if(Math.abs(left-right)<=1){
			//平衡二叉树
			return 1+Math.max(left,right);
		}else {
			return -1;
		}
	}
}
