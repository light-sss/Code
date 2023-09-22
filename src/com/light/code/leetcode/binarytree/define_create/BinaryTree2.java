package com.light.code.leetcode.binarytree.define_create;


/**
 * @author light
 * @Description 利用数组创建二叉树
 * @create 2023-08-14 12:38
 */
public class BinaryTree2 {
	public TreeNode root; //根节点
	public int size;  //树的长度
	Integer[] data;

	public BinaryTree2(Integer[] data) {
		this.data=data;
		this.size=getSize(data);
		root=createTree(0);
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

	private TreeNode createTree(int index) {
		if(index>= data.length){
			return null;
		}
		if(data[index]==null){
			return null;
		}
		TreeNode node=new TreeNode(data[index]);
		node.left=createTree(2*index+1);
		node.right=createTree(2*index+2);
		return node;
	}
}
