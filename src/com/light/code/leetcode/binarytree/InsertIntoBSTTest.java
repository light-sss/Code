package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 二叉搜索树钟的插入操作
 *
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。输入数据保证,新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * 你可以返回任意有效的结果 。
 *
 * (思路：其实可以不考虑题目中提示所说的改变树的结构的插入方式。
 * 只要按照二叉搜索树的规则去遍历，遇到空节点就插入节点就可以了。
 * @create 2023-08-23 13:17
 */
public class InsertIntoBSTTest {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		//递归终止条件，当遍历到空节点时，就是要插入节点的时候，返回要插入的节点
		if(root==null){
			TreeNode node=new TreeNode(val);
			return node;
		}
		if(root.val<val){
			root.right=insertIntoBST(root.right,val);
		}
		if(root.val>val){
			root.left=insertIntoBST(root.left,val);
		}
		return  root;
	}
}
