package com.light.code.leetcode.linkedlist;

/**
 * @author light
 * @Description 设计链表
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val的节点。
 * 	如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * 	如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index个节点。
 *
 * @create 2023-07-23 13:24
 */
public class DesignListTest {
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
		myLinkedList.get(1);              // 返回 2
		myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
		myLinkedList.get(1);// 返回 3


	}
}

class MyLinkedList{
	int size; //存放链表元素个数
	ListNode dummyHead;//虚拟头结点

	public MyLinkedList() {
		size=0;
		dummyHead=new ListNode(0);//初始化虚拟头结点
	}

	public int get(int index) {
		if(index<0||index>=size){
			return -1;
		}
		ListNode cur=dummyHead;
		for(int i=0;i<=index;i++){
			cur=cur.next;
		}

		return cur.val;
	}

	public void addAtHead(int val) {
		addAtIndex(0,val);
	}

	public void addAtTail(int val) {
		addAtIndex(size,val);
	}

	public void addAtIndex(int index, int val) {
		if(index<0){
			index=0;  //默认查到第一个结点
		}
		if(index>size){
			return;  //index大于当前长度，不进行插入操作
		}
		ListNode node=new ListNode(val);
		ListNode cur=dummyHead;
		for (int i = 0; i < index; i++) {
			cur=cur.next;
		}
		node.next=cur.next;
		cur.next=node;
		size++;
	}

	public void deleteAtIndex(int index) {
		if(index>=size||index<0){
			return;
		}
		ListNode cur=dummyHead;
		for (int i = 0; i < index; i++) {
			cur=cur.next;
		}
		cur.next=cur.next.next;
		size--;
	}

}
