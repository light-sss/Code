package com.light.code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author light
 * @Description 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
	 * 左括号必须用相同类型的右括号闭合。
	 * 左括号必须以正确的顺序闭合。
	 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 采用栈解决
 * @create 2023-08-11 18:14
 */
public class IsValidTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		boolean res = isValid(s);
		System.out.println(res);
	}

	public static boolean isValid(String s) {
		Deque<Character> stack=new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char ch=s.charAt(i);
			if(ch=='('){
				stack.push(')');
			} else if (ch=='{') {
				stack.push('}');
			}else if (ch=='[') {
				stack.push(']');
			} else if (stack.isEmpty()||ch!=stack.peek()) {
				return false;
			}else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
