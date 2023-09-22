package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description 二叉树中序遍历
 * @create 2023-08-13 19:48
 */
public class InorderTraversalTest {
	public static void main(String[] args) {
		Integer[] data={1, 2, 4, null, null, 5, null, null, 3, null, null };
		BinaryTree tree=new BinaryTree(data);
		System.out.println("递归中序遍历");
		List<Integer> res1=inorderTraversal_Recursion(tree.root);
		System.out.println(res1);
		System.out.println("迭代中序遍历");
		List<Integer> res2=inorderTraversal_Iterate(tree.root);
		System.out.println(res2);

		System.out.println(tree.root);
	}

	//递归遍历(利用栈 中序遍历顺序: 左-中-右 入栈顺序： 左-右
	public static List<Integer> inorderTraversal_Recursion(TreeNode root) {
		List<Integer> res=new ArrayList<>();
		traversal_Recursion(root,res);
		return res;
	}

	public static void traversal_Recursion(TreeNode root,List<Integer> res){
		if(root==null){
			return;
		}
		traversal_Recursion(root.left,res);//左
		res.add(root.val);//中
		traversal_Recursion(root.right,res); //右

	}
	//迭代遍历
	public static List<Integer> inorderTraversal_Iterate(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		TreeNode cur=root;//用来遍历二叉树
		Deque<TreeNode> stack=new ArrayDeque<>(); //用来存放遍历过的结点
		if(cur==null){
			return list;
		}
		while(cur!=null||!stack.isEmpty()){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}else {
				cur=stack.pop();
				list.add(cur.val);
				cur=cur.right;
			}
		}
		return list;
	}
}
