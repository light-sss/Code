package com.light.code.leetcode.linkedlist;

import java.util.Scanner;

/**
 * @author light
 * @Description 反转链表
 * 给你单链表的头节点 head,请你反转链表,并返回反转后的链表。
 * @create 2023-07-23 13:42
 */
public class ReverseListTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		ListNode head=new ListNode(input.nextInt());
		ListNode nextNode=head;
		for (int i = 1; i < n; i++) {
			ListNode node=new ListNode(input.nextInt());
			nextNode.next=node;
			nextNode=nextNode.next;
		}
		head = reverseList(head);
		nextNode=head;
		while(nextNode!=null){
			System.out.print(nextNode.val+" ");
			nextNode=nextNode.next;
		}
	}
	public static  ListNode reverseList(ListNode head) {
		ListNode pre=null;
		ListNode temp=null;
		ListNode cur=head;
		while(cur!=null){
			temp=cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
		return pre;
	}
}
