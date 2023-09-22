package com.light.code.leetcode.linkedlist;

/**
 * @author light
 * @Description 定义链表
 * @create 2023-07-23 13:30
 */
public class ListNode {
	//定义链表
		int val;
		ListNode next;

		public ListNode(){

		}
		public ListNode(int val){
			this.val=val;
		}

		public ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
}
