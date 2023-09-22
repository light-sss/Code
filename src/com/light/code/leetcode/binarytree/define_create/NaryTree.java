package com.light.code.leetcode.binarytree.define_create;

/**
 * @author light
 * @Description 创建n叉树
 * @create 2023-08-15 19:00
 */
public class NaryTree {
	public NTreeNode root;

	int size;
	int index=0;
	public NaryTree(Integer[] data){
		this.size=getSize(data);
		root=createNTree(0,data);
	}

	private NTreeNode createNTree(int index,Integer[] data) {
		if(index>size){
			return null;
		}
		NTreeNode node=new NTreeNode(data[index++]);
		int i=index;
		while(data[i]!=null){
			node.children.add(new NTreeNode(data[i++]));
		}

		return node;
	}

	private int getSize(Integer[] data) {
		int size=0;
		for(Integer i:data){
			if(i!=null){
				size++;
			}
		}
		return size;
	}
}
