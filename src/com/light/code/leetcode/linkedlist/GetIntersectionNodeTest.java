package com.light.code.leetcode.linkedlist;

/**
 * @author light
 * @Description 链表相交
 * 给你两个单链表的头节点 headA 和 headB，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 * @create 2023-07-31 18:56
 */
public class GetIntersectionNodeTest {
	//核心代码模式通过
	public static void main(String[] args) {
		/**
		 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
		 * 输出：Intersected at '8'
		 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
		 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
		 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
		 */


	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){

			return null;
		}
		int lenA=0;
		int lenB=0;
		ListNode nodeA=headA;
		ListNode nodeB=headB;
		while(nodeA!=null){
			nodeA=nodeA.next;
			lenA++;
		}
		nodeA=headA;
		while(nodeB!=null){
			nodeB=nodeB.next;
			lenB++;
		}
		nodeB=headB;
		int len=lenA-lenB;
		if(len>0){
			while(len--!=0){
				nodeA=nodeA.next;
			}
		}else if(len<0){
			len=-len;
			while(len--!=0){
				nodeB=nodeB.next;
			}
		}
		while(nodeA!=null&&nodeB!=null){
			if(nodeA!=nodeB){
				nodeA=nodeA.next;
				nodeB=nodeB.next;
			}else {
				return nodeA;
			}
		}
		return null;
	}
}
