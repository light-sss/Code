package com.light.code.leetcode.binarytree.define_create;

/**
 * @author light
 * @Description 基于前序遍历创建二叉树
 * @create 2023-08-13 20:24
 */
public class BinaryTree {
	public TreeNode root; //根节点
	int size;  //树的长度
	int index=0;

	public BinaryTree(Integer[] data) {
		this.size=getSize(data);
		root=createTree(data);
	}

	private int getSize(Integer[] data) {
		int size=0;
		for(Integer i:data){
			if(i!=null){
				size++;
			}
		}
		return size;
	}

	/*
		基于前序遍历创建二叉树
		Integer[] data:数值数组
	 */
	public TreeNode createTree(Integer[] data){//递归生成二叉树
		Integer val=data[index++];
		if(val==null){
			return null;
		}
		TreeNode node=new TreeNode(val);
		node.left=createTree(data);
		node.right=createTree(data);
		return node;
	}


}
