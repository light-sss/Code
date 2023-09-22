package com.light.code.leetcode.binarytree.define_create;

import java.util.List;

/**
 * @author light
 * @Description 定义n叉树
 * @create 2023-08-15 18:48
 */
public class NTreeNode {
	public int val;
	public List<NTreeNode> children;

	public NTreeNode() {
	}

	public NTreeNode(int val) {
		this.val = val;
	}

	public NTreeNode(int val, List<NTreeNode> children) {
		this.val = val;
		this.children = children;
	}

}
