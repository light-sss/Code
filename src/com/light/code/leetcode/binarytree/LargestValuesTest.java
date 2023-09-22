package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description 在每个数行中找到最大值
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 * @create 2023-08-15 20:58
 */
public class LargestValuesTest {
	public static void main(String[] args) {
		Integer[] arr={1,3,2,5,3,null,9};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		List<Integer> res=largestValues(tree2.root);
		System.out.println(res);
	}
	public static List<Integer> largestValues(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		Deque<TreeNode> que=new ArrayDeque<>();
		if(root==null){
			return list;
		}
		que.offer(root);
		while(!que.isEmpty()){
			int size=que.size();
			int max=que.peek().val;
			while (size>0){
				TreeNode node=que.poll();
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
				max=max>node.val?max:node.val;
				size--;
			}
			list.add(max);
		}
		return list;
	}
}
