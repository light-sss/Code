package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * (不要去累加然后判断是否等于目标和，那么代码比较麻烦,可以用递减,
 * 让计数器count初始为目标和，然后每次减去遍历路径节点上的数值。
 *
 * 如果最后count == 0，同时到了叶子节点的话，说明找到了目标和。
 *
 * 如果遍历到了叶子节点，count不为0，就是没找到。
 * @create 2023-08-19 11:48
 */
public class HasPathSumTest {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root==null){
			return  false;
		}
		targetSum-=root.val;
		if(root.left==null&&root.right==null){
			return targetSum==0;
		}
		if(root.left!=null){
			targetSum-=root.left.val;
			boolean left=hasPathSum(root.left,targetSum);
			if(left){
				return true; //找到了
			}
			targetSum+=root.left.val;
		}
		if(root.right!=null){
			targetSum-=root.right.val;
			boolean right=hasPathSum(root.right,targetSum);
			if(right){
				return true; //找到了
			}
			targetSum+=root.right.val;
		}
		return false;
	}


}
