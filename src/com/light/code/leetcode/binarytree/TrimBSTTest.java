package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 修剪搜索二叉树
 *
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树不应该改变保留在树中的元素的相对结构
 * (如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，
 * 根节点可能会根据给定的边界发生改变。
 *
 *
 * @create 2023-08-25 10:19
 */
public class TrimBSTTest {

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root==null){
			return null;
		}
		//删除节点，返回删除后符和要求的节点
		if(root.val<low){
			TreeNode right=trimBST(root.right,low,high);
			return right;
		}
		if(root.val>high){
			TreeNode left=trimBST(root.left,low,high);
			return left;
		}
		//挂载节点
		root.left=trimBST(root.left,low,high);
		root.right=trimBST(root.right,low,high);
		return root;
	}
}
