package com.light.code.kamacoder;

/**
 * @author light
 * @Description 字符串的最大价值
 * 给定一个字符串 S，只包含 0 和 1 两个数字，下标从 1 开始，
 * 设第 i 位的价值为 vali，则vali的定义如下：
 *
 * 当 i = 1 时：val1 = 1；
 * 当 i > 1 时：
 *     若Si != S(i - 1)：vali = 1，
 *     若Si == S(i - 1)：vali = val(i - 1) + 1；
 * 字符串 S 的总价值等于 val1 + val2 + ... + valn（n为字符串 S 的长度）。
 * 你可以任意删除字符串 S 中的任意字符，使得字符串 S 的总价值能够达到最大。
 * @create 2023-08-17 6:02
 */
public class n2 {
	public static void main(String[] args) {

	}
}
