package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author light
 * @Description 找树左下角的值
 *
 * (最左侧的结点未必是左节点
 * @create 2023-08-19 10:40
 */
public class FindBottomLeftValueTest {

	public static int maxDepth=Integer.MIN_VALUE; //记录最大深度
	public static int value;
	//递归
	public static int findBottomLeftValue(TreeNode root) {
		findValue(root,0);
		return value;
	}

	private static void findValue(TreeNode root, int depth) {
		if(root.left==null&&root.right==null){
			if(maxDepth<depth){
				maxDepth=depth;
				value= root.val;
			}
		}
		if(root.left!=null){
			depth++;
			findValue(root.left,depth);
			depth--;
		}
		if(root.right!=null){
			depth++;
			findValue(root.right,depth);
			depth--;
		}
	}

	//迭代
	public static int findBottomLeftValue2(TreeNode root) {
		int value=0;
		if(root==null){
			return value;
		}
		Deque<TreeNode> que=new ArrayDeque<>();
		que.offer(root);
		while(!que.isEmpty()){
			int size=que.size();
			int count=size;
			while(size>0){
				TreeNode node=que.poll();
				if(count==size){
					value= node.val;
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
		return value;
	}
}
