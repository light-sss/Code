package com.light.code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author light
 * @Description 删除字符串中的所有相邻重复项
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * （利用栈
 * @create 2023-08-11 18:39
 */
public class RemoveDuplicatesTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		s=removeDuplicates(s);
		System.out.println(s);

	}
	public static String removeDuplicates(String s) {
		Deque<Character> stack=new ArrayDeque<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char ch=s.charAt(i);
			if(!stack.isEmpty()&&ch==stack.peek()){
				stack.pop();
			}else {
				stack.push(ch);
			}
		}
		String s1="";
		while(!stack.isEmpty()){
			s1=stack.pop()+s1;
		}
		return s1;
	}
}
