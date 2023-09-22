package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 *
 * （思路：利用二叉搜索树的特性（有序）
 * 从上到下去遍历,遇到 cur节点是数值在[p,q]区间中则一定可以说明
 * 该节点cur就是q和p的公共祖先。也一定是最近公共祖先。
 * @create 2023-08-23 12:41
 */
public class LowestCommonAncestor2Test {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		while (root!=null){
			if(root.val>=p.val&&root.val<=q.val||root.val<=p.val&&root.val>=q.val||root==null){
				return root;
			}
			if(root.val>p.val&&root.val>q.val){
				root=root.left;
			}else if(root.val<p.val&&root.val<q.val){
				root=root.right;
			}
		}
		return root;
	}
	//递归
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null){
			return null;
		}
		if(root.val>p.val&&root.val>q.val){
			TreeNode left=lowestCommonAncestor1(root.left,p,q);
			if(left!=null){
				return left;
			}
		}
		if(root.val<p.val&&root.val<q.val){
			TreeNode right=lowestCommonAncestor1(root.right,p,q);
			if(right!=null){
				return right;
			}
		}
		return root;


	}
}
