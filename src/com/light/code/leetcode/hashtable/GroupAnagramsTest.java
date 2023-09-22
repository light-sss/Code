package com.light.code.leetcode.hashtable;

import java.util.*;

/**
 * @author light
 * @Description 字母异位词分组
 *
 * 方法一：排序
 * 由于互为字母异位词的两个字符串包含的字母相同，
 * 因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
 * 故可以将排序之后的字符串作为哈希表的键。
 * @create 2023-08-01 14:37
 */
public class GroupAnagramsTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] strs=input.next().split(",");
		List<List<String>> res=groupAnagrams(strs);
		System.out.println(res);
	}
	public static List<List<String>> groupAnagrams(String[] strs){
		Map<String,List<String>> map=new HashMap<>();
		for(String str:strs){
			char[] array=str.toCharArray();
			Arrays.sort(array);
			String key=Arrays.toString(array);
			List<String> list=map.getOrDefault(key,new ArrayList<>());
			list.add(str);
			map.put(key,list);
		}
		return new ArrayList<List<String>>(map.values());

	}
}
