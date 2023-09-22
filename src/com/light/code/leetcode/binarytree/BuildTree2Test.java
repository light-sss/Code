package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author light
 * @Description 从前序与中序遍历序列构造二叉树
 *
 *给定两个整数数组 preorder和inorder,其中 preorder是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @create 2023-08-20 11:00
 */
public class BuildTree2Test {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] preorder=new int[n];
		for (int i = 0; i < n; i++) {
			preorder[i]=input.nextInt();
		}
		int[] inorder=new int[n];
		for (int i = 0; i < n; i++) {
			inorder[i]=input.nextInt();
		}
		TreeNode treeNode=buildTree(preorder,inorder);
		System.out.println(LevelOrderTest.levelOrder(treeNode)); //层序遍历输出二叉树
	}

	public static Map<Integer,Integer> map;
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0||inorder.length==0){
			return null;
		}
		map=new HashMap<>();
		//用map中存放中序数组的值和下标: key--inorder[i];value--i
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i],i);
		}

		//左闭右闭
		return findNode(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

	}

	private static TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
		if(preBegin>preEnd||inBegin>inEnd){
			return null;
		}

		int rootIndex=map.get(preorder[preBegin]); //找到根节点在中序数组中的下标
		int rootValue=inorder[rootIndex];
		TreeNode root=new TreeNode(rootValue); //构造节点

		int lenOfLeft=rootIndex-inBegin; // 保存中序左子树个数，用来确定前序数列的个数

		//前左，中左
		root.left=findNode(preorder,preBegin+1,preBegin+lenOfLeft,inorder,inBegin,rootIndex-1);
		//前右，中由
		root.right=findNode(preorder,preBegin+lenOfLeft+1,preEnd,inorder,rootIndex+1,inEnd);



		return root;
	}

}
