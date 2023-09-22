package com.light.code.leetcode.cupidity;

import java.util.Scanner;

/**
 * @author light
 * @Description 跳跃游戏II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * (思路：还是要看覆盖范围，如果当前覆盖范围未达到终点，则步数+1；
 * 若当前覆盖范围达到最大值，步数不用+1
 *
 * @create 2023-09-05 10:30
 */
public class JumpTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int[] nums=new int[n];
		for (int i = 0; i < n; i++) {
			nums[i]=input.nextInt();
		}
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		if(nums.length==1){
			return 0;
		}
		int count=0;
		int coverRange=0; //当前覆盖范围---下标值
		int nextCoverRange=0; //下一步覆盖范围
		for (int i = 0; i < nums.length; i++) {
			//coverRange=i+nums[i];
			nextCoverRange=Math.max(nextCoverRange,i+nums[i]);
			if(i==coverRange){
				if(coverRange!= nums.length-1){
					count++;
					coverRange=nextCoverRange;
					if(coverRange>= nums.length-1){
						break;
					}
				}else {
					break;
				}
			}
		}
		return count;
	}
}
