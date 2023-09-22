package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 相同的数
 * @create 2023-08-18 11:32
 */
public class IsSameTreeTest {
	public static void main(String[] args) {
		Integer[] p={1,2,3};
		BinaryTree2 tree1=new BinaryTree2(p); //按数组方式创建二叉树
		Integer[] q={1,2,3};
		BinaryTree2 tree2=new BinaryTree2(q); //按数组方式创建二叉树
		System.out.println(isSameTree(tree1.root, tree2.root));

	}
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}
		//if(p==null&&q!=null){
		//	return false;
		//} else if (p!= null && p== null) {
		//	return false;
		//} else if (p.val!= q.val ) {
		//	return false;
		//}
		if(p==null||q==null){
			return false;
		}else if(p.val!=q.val){
			return false;
		}
		boolean left=isSameTree(p.left,q.left); //左
		boolean right=isSameTree(p.right,q.right); //右
		boolean isSame=left&&right; //中
		return isSame;
	}
}
