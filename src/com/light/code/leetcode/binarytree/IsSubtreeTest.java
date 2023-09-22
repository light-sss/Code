package com.light.code.leetcode.binarytree;

import com.light.code.leetcode.binarytree.define_create.BinaryTree2;
import com.light.code.leetcode.binarytree.define_create.TreeNode;

/**
 * @author light
 * @Description 另一棵树的子树
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。
 * tree 也可以看做它自身的一棵子树。
 *
 * (思路：要判断一个树 t 是不是树 s 的子树，那么可以判断 t 是否和树 s 的任意子树相等。那么就转化成 100. Same Tree。
 * 即，这个题的做法就是在 s 的每个子节点上，判断该子节点是否和 t 相等。
 *
 * 判断两个树是否相等的三个条件是与的关系，即：
 * 当前两个树的根节点值相等；
 * 并且，s 的左子树和 t 的左子树相等；
 * 并且，s 的右子树和 t 的右子树相等。
 * 而判断 t 是否为 s 的子树的三个条件是或的关系，即：
 *
 * 当前两棵树相等；
 * 或者，t 是 s 的左子树；
 * 或者，t 是 s 的右子树。
 *
 * 作者：负雪明烛
 * 链接：https://leetcode.cn/problems/subtree-of-another-tree/solutions/235634/dui-cheng-mei-pan-duan-zi-shu-vs-pan-duan-xiang-de/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @create 2023-08-18 11:46
 */
public class IsSubtreeTest {
	public static void main(String[] args) {
		Integer[] root = {1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2};
		Integer[] subRoot = {1,null,1,null,1,null,1,null,1,null,1,2};
		BinaryTree2 tree1=new BinaryTree2(root); //按数组方式创建二叉树
		BinaryTree2 tree2=new BinaryTree2(subRoot); //按数组方式创建二叉树
		System.out.println(isSubtree(tree1.root, tree2.root));
	}

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		//判断是否是子树
		if(root==null&&subRoot==null){
			return true;
		}
		if(root==null||subRoot==null){
			return false;
		}
		return isSameTree(root,subRoot)||isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
	}

	private static boolean isSameTree(TreeNode s, TreeNode t) {
		//这里转化为两棵树是否相等
		if(s==null&&t==null){
			return true;
		}
		if(s==null||t==null){
			return false;
		} else if (s.val!= t.val) {
			return false;
		}

		return isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
	}
}
