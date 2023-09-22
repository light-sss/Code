package com.light.code.leetcode.cupidity;

import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * （思路：摄像头需要放在叶子结点的父结点处，才能保证所放的摄像头最少
 *
 *
 * 节点状态：
 * 0.本节点无覆盖
 * 1.本节点有摄像头
 * 2.本节点有覆盖
 *特殊节点处理：空节点---有覆盖
 *
 * 根据底层节点返回来的状态决定该节点的状态
 * 对于每一节点有四种情况
 * 1.左右孩子都有覆盖---中间结点父无覆盖
 * 2.左右孩子至少一个无覆盖---中间结点父放摄像头
 * 3.左右孩子有一个有摄像头---中间父节点有覆盖
 * 4.头结点没有覆盖
 * @create 2023-09-10 16:56
 */
public class MinCameraCoverTest {
	int count=0;
	public int minCameraCover(TreeNode root) {
		if(minCamera(root)==0){ //对根节点进行校验，防止根节点无覆盖
			count++;
		}
		return count;
	}

	private int minCamera(TreeNode root) {
		if(root==null){
			return 2;  //空节点---有覆盖
		}

		//左
		int left=minCamera(root.left);
		//右
		int right=minCamera(root.right);
		//中
		//1.左右孩子都有覆盖---中间父节点无覆盖
		if(left==2&&right==2){
			return 0;
		}else if(left==0||right==0){
			// 2.左右孩子至少一个无覆盖---中间结点父放摄像头
			count++;
			return 1;
		} else  {
			// 3.左右孩子有一个有摄像头---中间父节点有覆盖
			return 2;
		}

	}
}
