package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author light
 * @Description 二叉搜索树中的众数
 *
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有众数
 * （即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按任意顺序返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于当前节点的值
 * 结点右子树中所含节点的值 大于等于当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 *
 * @create 2023-08-22 14:14
 */
public class FindModeTest {

	public List<Integer> list=new ArrayList<>();
	TreeNode pre=null;
	int count=0;
	int maxCount=0;
	public int[] findMode(TreeNode root) {
		findMax(root);
		int[] res=new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i]= list.get(i);
		}
		return res;
	}

	private void findMax(TreeNode root) {
		if(root==null){
			return;
		}
		findMax(root.left); //左

		if(pre==null){
			count=1;
		} else if (pre.val==root.val) {
			count++;
		}else {
			count=1;
		}
		pre=root;
		if(count==maxCount){
			list.add(root.val);
		} else if (count>maxCount) {
			maxCount=count;
			list.clear();
			list.add(root.val);
		}
		findMax(root.right);

	}
	
}
