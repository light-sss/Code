package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author light
 * @Description 二叉树的所有路径
 *
 * 给你一个二叉树的根节点 root ，按任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * @create 2023-08-18 16:25
 */
public class BinaryTreePathsTest {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,null,5};
		BinaryTree2 tree=new BinaryTree2(arr); //按数组方式创建二叉树
		List<String> path=binaryTreePaths(tree.root);
		System.out.println(path);
	}
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res=new ArrayList<>(); //存放结果
		if(root==null){
			return res;
		}
		List<Integer> path=new ArrayList<>(); //存放路径变量
		traversal(root,path,res);
		return res;
	}

	private static void traversal(TreeNode root, List<Integer> path, List<String> res) {

		path.add(root.val); //前序遍历：中

		if(root.left==null&&root.right==null){ //遇到叶子结点,及收获结果的时候
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < path.size()-1; i++) {
				sb.append(path.get(i)).append("->");
			}
			sb.append(path.get(path.size()-1));
			res.add(sb.toString());
			return;
		}
		if(root.left!=null){
			traversal(root.left,path,res); //前序遍历 左
			path.remove(path.size()-1);
		}
		if(root.right!=null){
			traversal(root.right,path,res); //前序遍历  右
			path.remove(path.size()-1);
		}
	}
}
