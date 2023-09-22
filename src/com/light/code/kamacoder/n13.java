package com.light.code.kamacoder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author light
 * @Description 路径简化
 * 假设你正在编写一个简单的 Unix 命令行模拟器，用户可以使用该模拟器来导航文件系统。
 * 用户可以输入 cd 命令来更改当前工作目录，并使用 pwd 命令来查看当前工作目录的路径。
 *
 * 但是，用户可能会输入复杂的路径，包括"/../"、"//"、"/./"或者多个连续的"/"等冗余部分，
 * 这会导致路径不太直观和容易理解。因此，你需要实现一个简化路径的功能，
 * 以确保路径始终保持干净、规范化和易于理解。
 *
 * 每次的 cd 命令都在根目录下进行执行。
 *
 * （思路：利用双端队列，首先将字符串以“/”分隔，遍历后的字符串：
 * 		若遇到字母，则加入队列
 * 		若遇到“..”且队列不为空，则将队头元素出队列----对应着返回上级目录
 * 		遇到“.”不用管---对应当前目录
 * 	最后将队列元素与“/”拼接
 *
 * @create 2023-09-07 19:00
 */
public class n13 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s;
		//s=s.substring(4);
		//System.out.println(simplify(s));

		while(input.hasNextLine()){
			s=input.nextLine();
			s=s.substring(3);
			System.out.println(simplify(s));
		}
	}

	private static String simplify(String s) {
		Deque<String> que=new ArrayDeque<>();
		for (String i :s.split("/")) {
			if(i.equals("..")&&!que.isEmpty()){
				que.removeLast();  //返回上层目录
			} else if (!i.equals("..")&&!i.equals(".")&&!i.equals("")) {
				que.add(i);
			}
		}
		StringBuilder sb=new StringBuilder();
		while (!que.isEmpty()&&que.peek()!=""){
			sb.append("/");
			sb.append(que.removeFirst());
		}

		return sb.toString().length()==0?"/":sb.toString();
	}
}
