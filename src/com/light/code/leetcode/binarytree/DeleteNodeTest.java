package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点root和一个值 key，删除二叉搜索树中的 key对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * （思路：删除二叉树中节点可以分为以下几种情况：
 * 		1.未找到要删除的节点
 * 		2.找到要删除的节点：
 * 			2.1	删除节点为叶子结点---直接删除
 * 			2.2 删除节点不是叶子结点，但其左孩子为空，右孩子不为空---直接让其父节点指向该节点的右孩子
 * 			2.3	删除节点不是叶子结点，但其右孩子为空，左孩子不为空---直接让其父节点指向该节点的左孩子
 * 			2.4 删除节点不是叶子结点，且左右孩子均不为空：
 * 				右孩子继位，将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上
 * @create 2023-08-23 13:40
 */
public class DeleteNodeTest {

	public TreeNode deleteNode(TreeNode root, int key) {
		//递归终止条件:遇到空直接返回（没找到要删除的节点
		if(root==null){
			return root;
		}

		//找到要删除的节点:返回删除后的根节点
		if(root.val==key){
			//1.删除节点为叶子结点
			if(root.left==null&&root.right==null){
				return null;
			} else if (root.left!=null&&root.right==null) { //2.删除节点左孩子不为空
				return root.left;
			} else if (root.right != null&&root.left==null) { //3.删除节点右孩子不为空
				return root.right;
			}else{  //4.删除节点左右孩子均不为空
				TreeNode node=root.right;
				while(node.left!=null){
					node=node.left;    //找到右子树的最左边的节点
				}
				node.left=root.left;   //把要删除的节点（root）左子树放在cur的左孩子的位置
				return root.right;
			}
		}
		if(root.val>key){
			root.left=deleteNode(root.left, key);
		}
		if(root.val<key){
			root.right=deleteNode(root.right,key);
		}
		return root;
	}
}
