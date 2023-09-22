package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 完全二叉树的节点个数
 *
 * 给你一棵完全二叉树的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 ：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * (思路：当完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
 *
 * 对于情况一，可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
 * 对于情况二，分别递归左孩子和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，
 *		然后依然可以按照情况1来计算。
 * @create 2023-08-18 14:52
 */
public class CountNodesTest {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6};
		BinaryTree2 tree=new BinaryTree2(arr); //按数组方式创建二叉树
		System.out.println(countNodes(tree.root));
	}
	public static int countNodes(TreeNode root) {
		/*   递归：普通二叉树
		//if(root==null){
		//	return 0;
		//}
		////左
		//int leftNum=countNodes(root.left);
		//int rightNum=countNodes(root.right);
		//int res=leftNum+rightNum+1;
		//return res;

		 */

		//完全二叉树
		if(root==null){
			return 0;
		}
		TreeNode leftNode=root.left;
		TreeNode rightNode=root.right;
		int leftDepth=0; //为了便于计算
		int rightDepth=0;
		while(leftNode!=null){
			leftNode=leftNode.left;
			leftDepth++;
		}
		while(rightNode!=null){
			rightNode=rightNode.right;
			rightDepth++;
		}
		if(leftDepth==rightDepth){
			return (2<<leftDepth)-1;  //满二叉树结点数计算 ；注意(2<<1) 相当于2^2，
		}

		int leftNum=countNodes(root.left);  //左
		int rightNum=countNodes(root.right); //右
		int res=leftNum+rightNum+1; //中
		return res;



	}
}
