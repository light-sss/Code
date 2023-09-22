package com.light.code.leetcode.linkedlist;

import java.util.Scanner;

/**
 * @author light
 * @Description 两两交换链表的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @create 2023-07-23 15:02
 */
public class SwapPairsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		ListNode head=new ListNode(input.nextInt());
		ListNode nextNode=head;
		for (int i = 1; i <n ; i++) {
			ListNode node=new ListNode(input.nextInt());
			nextNode.next=node;
			nextNode=nextNode.next;
		}
		head=swapPairs(head);
		nextNode=head;
		while(nextNode!=null){
			System.out.print(nextNode.val+" ");
			nextNode=nextNode.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode dummyHead=new ListNode(0,head);
		ListNode cur=dummyHead;
		ListNode temp=new ListNode();
		ListNode temp1=new ListNode();
		while(cur.next!=null&&cur.next.next!=null){
			temp=cur.next;
			temp1=cur.next.next.next;
			cur.next=cur.next.next;
			cur.next.next=temp;
			temp.next=temp1;
			cur=cur.next.next;
		}
		return dummyHead.next;
	}
}
