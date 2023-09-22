package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author light
 * @Description 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @create 2023-08-18 10:28
 */
public class IsSymmetricTest {
	public static void main(String[] args) {
		Integer[] arr={2,3,3,4,5,5};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		//递归
		boolean symmetric = isSymmetric(tree2.root);
		System.out.println(symmetric);
		//使用队列
		System.out.println(isSymmetric_Queue(tree2.root));
		//使用栈
		//System.out.println(isSymmetric_Stack(tree2.root));
	}
	public static boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		//递归
		return compare_Recursion(root.left,root.right);
	}

	//使用队列
	public static boolean isSymmetric_Queue(TreeNode root) {
		if(root==null){
			return true;
		}
		Deque<TreeNode> que=new LinkedList<>();
		que.offer(root.left);
		que.offer(root.right);
		while(!que.isEmpty()){
			TreeNode leftNode=que.pollFirst();
			TreeNode rightNode=que.pollFirst();
			if(leftNode==null&&rightNode==null){
				continue;
			}
			if(leftNode!=null&&rightNode==null){
				return false;
			} else if (leftNode==null&&rightNode!=null) {
				return false;
			} else if (leftNode.val!=rightNode.val) {
				return false;
			}
			que.offer(leftNode.left);
			que.offer(rightNode.right);
			que.offer(leftNode.right);
			que.offer(rightNode.left);
		}
		return true;
	}


	//递归
	private static boolean compare_Recursion(TreeNode left, TreeNode right) {
		if(left!=null&&right==null){
			return false;
		} else if (left==null&&right!=null) {
			return false;
		} else if (left == null && right == null) {
			return true;
		} else if (left.val!=right.val) {
			return false;
		}

		boolean outSide=compare_Recursion(left.left,right.right); //左子树：左；右子树：右
		boolean inSide=compare_Recursion(left.right,right.left); //左子树：右； 右子树：左
		boolean isSame=outSide&&inSide;

		return isSame;
	}
}
