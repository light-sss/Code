package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * (判断该节点是否是左叶子不能靠当前结点判断，而是靠父节点其左孩子是不是来判断的
 * @create 2023-08-19 10:17
 */
public class SumOfLeftLeavesTest {
	public static void main(String[] args) {
		Integer[] arr={3,9,20,null,null,15,7};
		BinaryTree2 tree=new BinaryTree2(arr); //按数组方式创建二叉树
		System.out.println(sumOfLeftLeaves(tree.root));
	}
	public static int sumOfLeftLeaves(TreeNode root) {
		//终止条件
		if(root==null){
			return 0;
		}
		//只有当前遍历的结点是父节点时，才能判断其子节点是否是左叶子
		if(root.left==null&&root.right==null){
			return 0;
		}
		//后序遍历
		int leftNum=sumOfLeftLeaves(root.left); //左
		if(root.left!=null&&root.left.left==null&&root.left.right==null){
			leftNum=root.left.val;
		}
		int rightNum=sumOfLeftLeaves(root.right); //右
		int sum=leftNum+rightNum;//中
		return sum;
	}
}
