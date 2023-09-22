package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description 二叉树的右视图
 *
 * 给定一个二叉树的根节点root，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 思路：
 * 层序遍历的时候，判断是否遍历到单层的最后面的元素，
 * 如果是，就放进result数组中，随后返回result就可以了。
 * @create 2023-08-15 17:49
 */
public class RightSideViewTest {
	public static void main(String[] args) {
		Integer[] arr={1,2,3,null,5,null,4};
		BinaryTree2 tree2=new BinaryTree2(arr); //按数组方式创建二叉树
		List<Integer> res=rightSideView(tree2.root);
		System.out.println(res);
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		Deque<TreeNode> que=new ArrayDeque<>();
		if(root==null){
			return list;
		}
		que.offer(root);
		while(!que.isEmpty()){
			int size=que.size();
			while(size>0){
				TreeNode node = que.poll();
				if(size==1){
					list.add(node.val);
				}
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
				size--;
			}
		}
		return list;
	}
}
