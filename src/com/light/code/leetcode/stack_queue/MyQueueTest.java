package com.light.code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author light
 * @Description 用栈实现队列
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作
 * （push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 *  定义两个栈，一个输入栈，一个输出栈
 *    入栈操作：将所有元素加入发到输入栈中
 *    出栈操作：要实现队列的先进先出，首先先判断输出栈中是否为空，如果为空，则将输入栈
 *      	   中的元素全部加入输出栈中，从输出栈中将元素弹出，以实现队列先进先出的功能
 * @create 2023-08-11 16:56
 */
public class MyQueueTest {
	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		int param_3 = obj.peek();
		System.out.println(param_3);
		int param_2 = obj.pop();
		System.out.println(param_2);
		boolean param_4 = obj.empty();
		System.out.println(param_4);
	}

}
class MyQueue {
	Deque<Integer> stackIn;
	Deque<Integer> stackOut;

	public MyQueue() {
		stackIn=new ArrayDeque<>();
		stackOut=new ArrayDeque<>();
	}

	public void push(int x) {
		stackIn.push(x);
	}

	public int pop() {
		dumpstackIn();
		return stackOut.pop();
	}

	public int peek() {
		dumpstackIn();

		return stackOut.peek();
	}

	public boolean empty() {
		return stackIn.isEmpty()&&stackOut.isEmpty();
	}

	public void dumpstackIn(){

		if(stackOut.isEmpty()){
			//如果输出栈中为空，将输入栈中所有元素加入到输出栈中
			while(!stackIn.isEmpty()){

				stackOut.push(stackIn.pop());
			}
		}

	}
}
