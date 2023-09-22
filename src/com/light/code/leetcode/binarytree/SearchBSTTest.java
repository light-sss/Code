package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。
 * 如果节点不存在，则返回 null 。
 *
 * （思路:按照搜索树特性解题--左子树节点值比根节点值小；右子树节点值比根节点值大
 * @create 2023-08-22 10:55
 */
public class SearchBSTTest {

	public TreeNode searchBST(TreeNode root, int val) {
		if(root==null||root.val==val){
			return root;
		}
		TreeNode result=null;
		if(root.val>val){
			result=searchBST(root.left,val);
		}
		if(root.val<val){
			result=searchBST(root.right,val);
		}
		return result;

	}
}

