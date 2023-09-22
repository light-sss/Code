package com.light.code.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**https://leetcode.cn/problems/minimum-window-substring/description/
 * @author light
 * @Description 最小覆盖子串
 * 给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串。
 * 如果 s 中不存在涵盖t所有字符的子串，则返回空字符串 "" 。
 *
 * 滑动窗口
 * @create 2023-07-23 10:59
 */
public class MinWindowTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		String t=input.next();
		String res = minWindow(s, t);
		System.out.println(res);

	}
	public static String minWindow(String s, String t) {
		Map<Character,Integer> map=new HashMap<>();
		int m=s.length();
		int n=t.length();
		char ch;
		//初始化哈希表中为t中字符的数量
		for (int i = 0; i < n; i++) {
			ch=t.charAt(i);
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		//滑动窗口中缺失字符串t中字符串的种类的数量，
		//当diff为0时，说明滑动窗口涵盖了t中所有字符
		int diff=map.size();
		int left=0;  //滑动窗口左边界
		int right=0; //滑动窗口右边界
		int minLength=m+1; //最小长度初始化为一个不可能的数字
		int subStrStart=-1; //最小子串起点，最终要返回的是子串，通过start和minLength确定子串范围
		while(right<=m){
			if(diff>0){
				//还有缺失字符
				if(right==m){
					break;  //没有可以加入的字符，直接退出
				}
				// 获取右边界指向的字符，右边界右移一位
				ch=s.charAt(right++);
				// 右边界字符加入滑动窗口，该字符的差距值 - 1
				map.put(ch,map.getOrDefault(ch,0)-1);
				if(map.get(ch)==0){
					// 如果这个字符数量为0，说明新加入的字符使
					// 得有一种字符的数量满足要求，差值diff减1
					diff--;
				}
			}else {
				//没有缺失字符，当前滑动窗口维护的子串即为一个满足条件的子串
				if(right-left<minLength){
					minLength=right-left;
					subStrStart=left;
				}
				// 获取左边界指向的字符，左边界右移一位；尝试获取更短的子串
				ch=s.charAt(left++);
				// 左边界字符移出滑动窗口，该字符的差距值 + 1
				map.put(ch,map.getOrDefault(ch,0)+1);
				if(map.get(ch)==1){
					// 如果这个字符数量为1，说明原本为0，移除的字符使得有一种字符的数量欠缺了，因此差值diff+1
					diff++;
				}
			}
		}
		return minLength==m+1?"":s.substring(subStrStart,subStrStart+minLength);
	}
}
