package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author light
 * @Description 路径总和II
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * @create 2023-08-19 14:12
 */
public class PathSumTest {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res=new ArrayList<>(); //存放结果集
		List<Integer> path=new ArrayList<>(); //存放路径变量
		getPaths(root,targetSum-root.val,path,res);
		return res;
	}

	private void getPaths(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
		path.add(root.val);
		if(root.left==null&&root.right==null){
			if(targetSum-root.val==0){
				res.add(new ArrayList<>(path));
			}
			return;
		}
		if(root.left!=null){
			targetSum-=root.val;
			getPaths(root.left,targetSum,path,res);
			path.remove(path.size()-1);
			targetSum+=root.val;
		}
		if(root.right!=null){
			targetSum-=root.val;
			getPaths(root.right,targetSum,path,res);
			path.remove(path.size()-1);
			targetSum+=root.val;
		}

	}
}
