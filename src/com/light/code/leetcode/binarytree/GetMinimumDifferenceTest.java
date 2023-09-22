package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 二叉搜索树的最小绝对差
 *
 * (思路：利用二叉搜索树特性，自我理解：在中序遍历中，二叉树遍历出来是有序数组，
 * 求任意两节点间最小差值就是求遍历过程中相邻两节点的差值的最小值；
 * @create 2023-08-22 13:49
 */
public class GetMinimumDifferenceTest {

	TreeNode pre=null; //记录上一个节点
	int result=Integer.MAX_VALUE; //记录最小差值
	public int getMinimumDifference(TreeNode root) {
		if(root==null){
			return 0;
		}
		traversal(root);
		return result;

	}

	private void traversal(TreeNode root) {

		if(root==null){
			return;
		}

		//中序遍历：左
		traversal(root.left);

		//中序遍历：中
		if(pre!=null){
			result=Math.min(result,root.val-pre.val);
		}
		pre=root;

		//中序遍历：右
		traversal(root.right);

	}
}
