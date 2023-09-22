package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 *
 *（思路：对于一个结点，只要其左子树出现p或q，或右子树出现p或q，那么该节点就是节点p和q的最近公共祖先；
 *如果递归遍历遇到q，就将q返回，遇到p就将p返回，那么如果左右子树的返回值都不为空，说明此时的中节点，一定是q和p的最近祖先。
 *
 *
 * @create 2023-08-23 11:52
 */
public class LowestCommonAncestorTest {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//递归结束条件
		if(root==p||root==q||root==null){
			return root;
		}

		//左
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		//右
		TreeNode right=lowestCommonAncestor(root.right,p,q);

		//中
		if(left!=null&&right!=null){
			return  root;  //最近公共祖先
		}else if(left==null&&right!=null){
			return right;   // 若找到一个节点  继续向上返回直到根节点
		} else if (left != null && right == null) {
			return left;   // 若找到一个节点  继续向上返回直到根节点
		}else {
			return null;   //没找到结点
		}
	}
}
