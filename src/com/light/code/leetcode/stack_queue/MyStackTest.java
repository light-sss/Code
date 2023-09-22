package com.light.code.leetcode.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author light
 * @Description 用队列实现栈
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作
 * （push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 *
 * @create 2023-08-11 17:28
 */
public class MyStackTest {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.top()); // 返回 2
		System.out.println(myStack.pop()); // 返回 2
		System.out.println(myStack.empty()); // 返回 False
	}
}
class MyStack {
	Deque<Integer> que1;
	Deque<Integer> que2;

	public MyStack() {
		que1=new LinkedList<>();
		que2=new LinkedList<>();
	}

	public void push(int x) {
		que1.add(x);
	}

	public int pop() {
		while(que1.size()!=1){
			que2.add(que1.pop());
		}
		int res=que1.pop();

		while(!que2.isEmpty()){
			que1.add(que2.pop());
		}
		return res;

	}

	public int top() {

	return que1.peekLast();

	}

	public boolean empty() {
		return que1.isEmpty();
	}
}
