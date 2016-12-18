package com.artoo.java_traps.demos;

public class InTheLoop {
	public static final int END = Integer.MAX_VALUE;
	public static final int START = END - 100;

	/**
	 * 问题在于这个循环会在循环索引(i)小于或等于 Integer.MAX_VALUE 时持续运行,但是所有的 int 变量都是小于或等于
	 * Integer.MAX_VALUE 的。因为它被定义为所有 int 数值中的最大值。当 i 达到
	 * Integer.MAX_VALUE,并且再次被执行增量操作时,它就有绕回到了 Integer.MIN_VALUE。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(END);
		System.out.println(END + 1);
		System.out.println(START);
		int count = 0;
		// 死循环
		for (int i = START; i <= END; i++)
			count++; // 绕回到了 Integer.MIN_VALUE,参考END + 1
		System.out.println(count);

		// int 不能表示所有的整数。无论你在何时使用了一个整数类型, 都要意识到其边界条件。

	}

}
