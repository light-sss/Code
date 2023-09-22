package com.light.code.leetcode.linkedlist;

import java.util.Scanner;

/**
 * @author light
 * @Description  环形链表II
 * 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表
 * 实示例1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @create 2023-07-31 21:02
 */
public class DetectCycleTest {
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
		ListNode lastNode=nextNode;
		int target=input.nextInt();
		nextNode=head;
		if(target>=0){ //加环
			while(target-->0){
				nextNode=nextNode.next;
			}
			lastNode.next=nextNode;
		}

		ListNode node=detectCycle(head);
		int pos=0;
		if(node==null){
			//链表中无环
			System.out.println("no cycle");
		}else{
			nextNode=head;
			while(nextNode!=node){
				nextNode=nextNode.next;
				pos++;
			}
			System.out.println(pos);
		}

	}

	public static ListNode detectCycle(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		ListNode index1;
		ListNode index2;

		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				index1=slow;
				index2=head;
				while (index1!=index2){
					index1=index1.next;
					index2=index2.next;
				}
				return index1;
			}
		}

		return null;
	}
}
