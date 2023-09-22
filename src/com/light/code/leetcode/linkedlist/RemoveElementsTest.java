package com.light.code.leetcode.linkedlist;

import java.util.Scanner;

/**
 * @author light
 * @Description 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点。
 *
 * 添加虚拟头结点方式
 * @create 2023-07-23 12:36
 */
public class RemoveElementsTest {
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
		int target=input.nextInt();
		head = removeElements(head, target);
		nextNode=head;
		while(nextNode!=null){
			System.out.print(nextNode.val+" ");
			nextNode=nextNode.next;
		}

	}
	public static ListNode removeElements(ListNode head, int target) {
		//定义虚拟头结点
		ListNode dummyHead=new ListNode();
		dummyHead.next=head;
		ListNode cur=dummyHead;
		while(cur!=null&&cur.next!=null){
			if(cur.next.val== target){
				cur.next=cur.next.next;
			}else{
				cur=cur.next;
			}
		}
		return dummyHead.next;
	}
}

