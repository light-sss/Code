package com.light.code.kamacoder;

import java.util.Scanner;

/**
 * @author light
 * @Description 虚拟棋盘对战
 * 两个玩家在一款虚拟棋盘游戏中对战，棋盘上有一行格子，长度为 n，
 * 每个格子上都有不同的分数。玩家 A 和玩家 B 轮流选择一个格子，
 * 他们都希望最终获得的总分数更高。规则是，
 * 每个玩家可以选择棋盘上的任何一端的格子，然后将该格子上的分数加入自己的总分。
 * 游戏结束后，获得最高总分的玩家获胜。
 *
 * 两位玩家都非常聪明，他们会采用最优策略来选择格子以最大化自己的得分。
 *
 * （思路：动规
 * @create 2023-09-07 19:24
 */
public class n15 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] num=new int[n];
		for (int i = 0; i < n; i++) {
			num[i]=input.nextInt();
		}
		System.out.println(maxScore(num));
	}

	private static int maxScore(int[] num) {
		int[][] F=new int[num.length][num.length]; //先选的人能拿到的最高分
		int[][] S=new int[num.length][num.length]; //后选的人能拿到的最高分
		/**
		 * 对于先选的人有两种选法：
		 *  1.先选num[0],则对于后面的1,...,n-1数组，他变成l后选者，此时能拿到的分数是num[0]+s[1][n-1];
		 *  2.先选num[n-1],则对于前面的0,...,n-2数组，他变成了后选者,此时能拿到的分数是num[n-1]+s[0][n-2];
		 */


		return 0;

	}

}
