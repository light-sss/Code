package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author light
 * @Description 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * @create 2023-08-20 9:48
 */
public class BuildTreeTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] inorder=new int[n];
		for (int i = 0; i < n; i++) {
			inorder[i]=input.nextInt();
		}
		int[] postorder=new int[n];
		for (int i = 0; i < n; i++) {
			postorder[i]=input.nextInt();
		}
		TreeNode treeNode = buildTree(inorder, postorder);
		System.out.println(LevelOrderTest.levelOrder(treeNode)); //层序遍历输出二叉树
	}
	public static Map<Integer,Integer> map;
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		map=new HashMap<>();
		if(postorder.length==0||inorder.length==0){
			return null;
		}
		//用map中存放中序数组的值和下标: key--inorder[i];value--i
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i],i);
		}
		//左闭右闭
		return findNode(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}

	private static TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
		if(inBegin>inEnd||postBegin>postEnd){
			return null;
		}

		int rootIndex=map.get(postorder[postEnd]); //找到后序数组最后一个元素在中序数组中的位置
		int rootValue=inorder[rootIndex]; //找到结点值
		TreeNode root=new TreeNode(rootValue); //构造节点

		//保存中序左子树个数，用于确定后序数组个数
		int lenOfLeft=rootIndex-inBegin;

		//中左序  后左序
		root.left=findNode(inorder,inBegin,rootIndex-1,postorder,postBegin,postBegin+lenOfLeft-1);
		//中右序  后右序
		root.right=findNode(inorder,rootIndex+1,inEnd,postorder,postBegin+lenOfLeft,postEnd-1);
		return root;

	}
}
