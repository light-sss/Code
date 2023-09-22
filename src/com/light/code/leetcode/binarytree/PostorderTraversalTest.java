package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.*;

/**
 * @author light
 * @Description 二叉树后序遍历
 * @create 2023-08-13 19:46
 */
public class PostorderTraversalTest {
	public static void main(String[] args) {
		Integer[] data={1, 2, 4, null, null, 5, null, null, 3, null, null };
		BinaryTree tree=new BinaryTree(data);

		System.out.println("递归后序遍历：");
		List<Integer> res1=postorderTraversal_Recursion(tree.root);
		System.out.println(res1);

		System.out.println("迭代后续遍历");
		List<Integer> res2=postorderTraversal_Iterate(tree.root);
		System.out.println(res2);

	}

	//迭代遍历
	public static List<Integer> postorderTraversal_Recursion(TreeNode root) {
		List<Integer> res=new ArrayList<>();
		traversal_Recursion(root,res);
		return res;
	}

	public static void traversal_Recursion(TreeNode root,List<Integer> res){
		if(root==null){
			return;
		}
		traversal_Recursion(root.left,res);//左
		traversal_Recursion(root.right,res);//右
		res.add(root.val);//中
	}
	//迭代遍历(利用栈:后序遍历顺序：左-右-中，入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
	public static List<Integer> postorderTraversal_Iterate(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		Deque<TreeNode> stack=new ArrayDeque<>();
		if(root==null){
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			list.add(node.val);
			if(node.left!=null){
				stack.push(node.left);
			}
			if(node.right!=null){
				stack.push(node.right);
			}
		}
		Collections.reverse(list);
		return list;
	}
}
