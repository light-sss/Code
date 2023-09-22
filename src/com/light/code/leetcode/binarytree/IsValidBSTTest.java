package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 验证二叉搜索树
 *
 *给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * (思路：利用特性，中序遍历的时候元素是有序的
 * 定义一个指针，始终指向root的前一个节点，中序遍历时，若pre>=root.val；
 * 则说明二叉树不是搜索二叉树
 * @create 2023-08-22 11:34
 */
public class IsValidBSTTest {
	public static void main(String[] args) {
		Integer[] arr={5,1,4,null,null,3,6};
		BinaryTree2 tree2=new BinaryTree2(arr);
		System.out.println(isValidBST(tree2.root));
	}

	public  static TreeNode pre=null;
	public static   boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;
		}

		//中序遍历：左
		boolean left=isValidBST(root.left);

		//中序遍历：中
		if(pre!=null&&pre.val>=root.val){
			return  false;
		}
		pre=root;
		//中序遍历：右
		boolean right=isValidBST(root.right);


		return left&&right;

	}
}
