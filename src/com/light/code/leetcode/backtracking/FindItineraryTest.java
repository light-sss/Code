package com.light.code.leetcode.backtracking;

import java.util.*;

/**
 * @author light
 * @Description 重新安排行程
 *
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi,toi] 表示飞机出发和降落的机场地点。
 * 请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 * @create 2023-08-30 10:16
 */
public class FindItineraryTest {

	public LinkedList<String> res;
	public LinkedList<String> path=new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		//对集合中元素降落地点排序
		Collections.sort(tickets, new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				return o1.get(1).compareTo(o2.get(1));
			}
		});
		path.add("JFK"); //从JFK出发
		boolean[] used=new boolean[tickets.size()]; //判断元素是否重复
		Arrays.fill(used,false);
		backtracking((ArrayList)tickets,used);
		return res;
	}

	private boolean backtracking(ArrayList<List<String>> tickets, boolean[] used) {
		//终止条件
		if(path.size()==tickets.size()+1){
			res=new LinkedList<>(path);  //只有一条路径
			return true;
		}

		for (int i = 0; i < tickets.size(); i++) {
			//未使用重复元素并且path中最后一个元素的值等于tickets数组航班中的起飞航班，则将降落航班加入path中
			if(!used[i]&&tickets.get(i).get(0).equals(path.getLast())){
				path.add(tickets.get(i).get(1));
				used[i]=true;
				if(backtracking(tickets,used)){
					return true;
				}
				//回溯
				used[i]=false;
				path.removeLast();
			}

		}
		return false;
	}

}
