package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 把二叉搜索树转换为累加树
 *
 * 给出二叉搜索树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 利用二叉搜索树特性--有序数组
 * @create 2023-08-25 11:44
 */
public class ConvertBSTTest {
	int pre=0;
	public TreeNode convertBST(TreeNode root) {
		 traversal(root);
		 return root;
	}

	private void traversal(TreeNode root) {
		if(root==null){
			return;
		}
		traversal(root.right);
		root.val+=pre;
		pre=root.val;
		traversal(root.left);
	}
}
