package com.light.code.kamacoder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author light
 * @Description  字符串解压缩
 *
 * 给定一个被压缩过的字符串，压缩规则如下：
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且0<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]。
 * 你的任务是解压被压缩过的字符串。
 *
 * (思路：利用栈/指针(利用递归的思想
 * @create 2023-08-17 4:53
 */
public class n1 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.nextLine(); //考虑字符串中有空格的情况

		//利用栈：卡玛网两个案例未通过（不知道是哪两个案例    通过案例数：7/9
		s=stringDecompression(s);
		//s=decode(s);
		System.out.println(s);
	}
	public static String stringDecompression(String s){
		Deque<Character> stack=new ArrayDeque<>();
		if(s==null){
			return "";
		}
		for (int i = 0; i < s.length(); i++) {
			char ch=s.charAt(i);
			if (ch!=']'){
				stack.push(ch);
			}else{
				Deque<Character> stackOut=new ArrayDeque();
				while(stack.peek()!='|'){
					stackOut.push(stack.pop());
				}
				stack.pop(); //出栈的是'|'
				int count=stack.pop()-'0';
				StringBuilder sb=new StringBuilder();
				while(!stackOut.isEmpty()){
					sb.append(stackOut.removeLast());
				}
				String s1=sb.toString();
				StringBuilder sb1=new StringBuilder();
				for(int j=1;j<=count;j++){
					sb1.append(s1); //解压缩
				}
				 s1=sb1.toString();
				for (int j = 0; j < s1.length(); j++) {
					char c=s1.charAt(j);
					stackOut.push(c);
				}
				if(stack.pop()=='['){
					while(!stackOut.isEmpty()){
						stack.push(stackOut.pop());
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.removeLast());
		}
		return sb.toString();
	}
	public static String decode(String s){
		int x=-1,y=-1,z=-1;
		int i=0;
		//第一次递归找最里面的三个分隔符
		while(i<s.length()){
			if(s.charAt(i)=='['){
				x=i;
			} else if (s.charAt(i)=='|') {
				y=i;
			} else if (s.charAt(i)==']') {
				z=i;
				break;
			}
			i++;
		}
		if(x!=-1&&y!=-1&&z!=-1){
			int items= Integer.parseInt(s.substring(x+1,y));
			String sub=s.substring(y+1,z);
			StringBuilder sb=new StringBuilder();
			for (int j = 1; j <=items ; j++) {
				sb.append(sub);
			}
			String decodeStr=s.substring(0,x)+sb.toString()+s.substring(z+1);
			return decode(decodeStr);
		}
		return s;
	}
}

