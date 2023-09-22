package com.light.code.leetcode.binarytree.define_create;

/**
 * @author light
 * @Description
 * @create 2023-08-15 21:36
 */
public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int val, Node left, Node right, Node next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}

	public Node(int val) {
		this.val = val;
	}
}
