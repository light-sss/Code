package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.Scanner;

/**
 * @author light
 * @Description 最大二叉树
 * @create 2023-08-21 13:54
 */
public class ConstructMaximumBinaryTreeTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		TreeNode treeNode = constructMaximumBinaryTree(nums);
		System.out.println(LevelOrderTest.levelOrder(treeNode));
	}
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length==1){
			return new TreeNode(nums[0]);
		}
		//左闭右闭
		return findNode(nums,0, nums.length-1);
	}

	private static TreeNode findNode(int[] nums, int begin, int end) {
		//递归终止条件
		if(begin>end){
			return null;
		}
		//数组中只有一个元素
		if(end-begin==0){
			return new TreeNode(nums[begin]);
		}

		int rootIndex=Integer.MIN_VALUE;
		int rootValue=Integer.MIN_VALUE;
		for (int i = begin; i <=end; i++) {
			if(nums[i]>rootValue){
				rootValue=nums[i]; //找到最大的根节点值
				rootIndex=i;
			}
		}
		TreeNode root=new TreeNode(rootValue);


		root.left=findNode(nums,begin,rootIndex-1);

		root.right=findNode(nums,rootIndex+1,end);

		return root;

	}
}
