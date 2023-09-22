package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums,其中元素已经按升序排列,请你将其转换为一棵高度平衡二叉搜索树。
 *
 * 高度平衡二叉树是一棵满足每个节点的左右两个子树的高度差的绝对值不超过1的二叉树。
 *
 *
 * @create 2023-08-25 10:51
 */
public class SortedArrayToBSTTest {

	public TreeNode sortedArrayToBST(int[] nums) {

		return traversal(nums,0,nums.length-1);
	}

	private TreeNode traversal(int[] nums, int left, int right) {
		if(left>right){
			return  null;
		}
		int mid=(left+right)/2; //取节点值下标
		TreeNode root=new TreeNode(nums[mid]);

		root.left=traversal(nums,left,mid-1);
		root.right=traversal(nums,mid+1,right);

		return root;
	}
}
