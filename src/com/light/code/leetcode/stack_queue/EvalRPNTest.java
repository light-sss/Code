package com.light.code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author light
 * @Description 逆波兰表达式求值
 *
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 *
 * (利用栈
 * @create 2023-08-12 13:36
 */
public class EvalRPNTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] tokens=input.next().split(",");
		int res=evalRPN(tokens);
		System.out.println(res);

	}
	public static int evalRPN(String[] tokens) {
		Deque<Integer> stack=new ArrayDeque<>();
		for (String s:tokens){
			if ("+".equals(s)) {
				stack.push(stack.pop()+stack.pop());
			} else if ("-".equals(s)) {
				//注意这里先入栈的作为减数
				stack.push(-stack.pop()+stack.pop());
			} else if ("*".equals(s)) {
				stack.push(stack.pop()*stack.pop());
			} else if ("/".equals(s)) {
				//注意这里先入栈的作为除数
				int temp1=stack.pop();
				int temp2=stack.pop();
				stack.push(temp2/temp1);
			}else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.peek();
	}
}
