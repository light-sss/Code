package com.light.code.leetcode.linkedlist;

import java.util.Scanner;

/**
 * @author light
 * @Description 删除链表的倒数第N个节点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 思路：（快慢指针
 * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，
 * 直到fast指向链表末尾。删掉slow所指向的节点就可以了。
 *
 * @create 2023-07-31 18:09
 */
public class RemoveNthFromEndTest {
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
		int target=input.nextInt();
		head=removeNthFromEnd(head,target);
		nextNode=head;
		while(nextNode!=null){
			System.out.print(nextNode.val + " ");
			nextNode=nextNode.next;
		}

	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead=new ListNode(0,head);
		ListNode fastNode=dummyHead;
		ListNode slowNode=dummyHead;
		while(n--!=0&&fastNode.next!=null){
			fastNode=fastNode.next;
		}
		while(fastNode.next!=null){
			fastNode=fastNode.next;
			slowNode=slowNode.next;
		}
		slowNode.next=slowNode.next.next;
		return dummyHead.next;
	}
}
