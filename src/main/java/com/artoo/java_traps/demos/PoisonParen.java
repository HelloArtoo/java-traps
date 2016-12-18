package com.artoo.java_traps.demos;

/**
 * 你能否举出这样一个合法的 Java 表达式,只要对它的某个子表达式加上括号就 可以使其成为不合法的表达式？
 * 
 * @author Administrator
 * 
 */
public class PoisonParen {
	/**
	 * 类似地,上述情况也适用于 long 型字面常量。下面这个程序也会产生一个编译 期错误,并且如果你去掉括号错误也会消失:
	 */
	long j = -(9223372036854774808L);

	/**
	 * -2,147,483,648（Integer.MIN_VALUE）<br/>
	 * 在 int 类型的十进制字面常量中,最大的是 2147483648。而从 0 到 2147483647 的所有十进制字面常量都可以在任何能够使用
	 * int 类型字面常量 的地方出现,但是字面常量 2147483648 只能作为一元负操作符的操作数来使用
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int i = -2147483648;
		int j = Integer.MIN_VALUE;

	}

}
