package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.NTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author light
 * @Description n叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）
 * @create 2023-08-15 20:40
 */
public class LevelOrder2Test {
	public static void main(String[] args) {

	}
	public static List<List<Integer>> levelOrder(NTreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		if(root==null){
			return res;
		}
		Deque<NTreeNode> que=new ArrayDeque<>();
		que.offer(root);
		while(!que.isEmpty()){
			List<Integer> list=new ArrayList<>();
			int size=que.size();
			while (size>0){
				NTreeNode node=que.poll();
				list.add(node.val);
				List<NTreeNode> children=node.children;
				if(children!=null){
					for(NTreeNode n:children){
						que.add(n);
					}
				}
				size--;
			}
			res.add(list);
		}
		return res;
	}
}
