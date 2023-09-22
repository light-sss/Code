package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author light
 * @Description 填充每个节点的下一个右侧节点指针
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * (思路：本题依然是层序遍历，只不过在单层遍历的时候记录一下本层的头部节点，
 * 然后在遍历的时候让前一个节点指向本节点就可以了
 * @create 2023-08-15 21:36
 */
public class ConnectTest {
	public static void main(String[] args) {

	}
	public static Node connect(Node root) {
		Deque<Node> que=new ArrayDeque<>();
		if(root==null){
			return null;
		}
		que.offer(root);
		while(!que.isEmpty()){
			int size=que.size();
			Node preNode=null;
			Node node=null;
			for (int i = 0; i < size; i++) {
				if(i==0){
					//取出本层头部结点
					preNode=que.poll();
					node=preNode;
				}else{
					node=que.poll();
					preNode.next=node;
					preNode=node;
				}
				if(node.left!=null){
					que.offer(node.left);
				}
				if(node.right!=null){
					que.offer(node.right);
				}
			}
			preNode.next=null; //本层最后一个节点指向null
		}
		return root;
	}
}
