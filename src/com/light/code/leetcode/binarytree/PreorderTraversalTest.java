package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description 二叉树的前序遍历
 * @create 2023-08-13 19:43
 */
public class PreorderTraversalTest {
	public static void main(String[] args) {
		Integer[] data={1, 2, 4, null, null, 5, null, null, 3, null, null };
		BinaryTree tree=new BinaryTree(data);
		System.out.println("递归前序遍历：");
		List<Integer> res1=preorderTraversal_Recursion(tree.root);
		System.out.println(res1);

		System.out.println("迭代前序遍历");
		List<Integer> res2=preorderTraversal_Iterate(tree.root);
		System.out.println(res2);

	}

	//递归遍历
	public static List<Integer> preorderTraversal_Recursion(TreeNode root) {
		List<Integer> res=new ArrayList<>();
		traversal_Recursion(root,res);
		return res;
	}
	public static void traversal_Recursion(TreeNode root,List<Integer> res){
		if(root==null){
			return ;
		}
		res.add(root.val); //中
		traversal_Recursion(root.left,res); //左
		traversal_Recursion(root.right,res); //右

	}
	//迭代遍历(利用栈:前序遍历顺序：中-左-右，入栈顺序：中-右-左
	public static List<Integer> preorderTraversal_Iterate(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		Deque<TreeNode> stack=new ArrayDeque<>();
		if(root==null){
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			list.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}
		}
		return list;
	}
}
