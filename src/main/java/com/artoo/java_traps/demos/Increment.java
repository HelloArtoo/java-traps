package com.artoo.java_traps.demos;

public class Increment {

	/**
	 * 表达式 j++的值等于 j 在执行增量操作之前的初始值。因此,前面提到的赋值语句首先保存 j 的值,然后将 j 设置为其值加 1,最后将 j
	 * 复位到它的初始值。换句话说,这个赋值操作等价于下面的语句序列: int tmp = j; j = j + 1; j = tmp?; 程序重复该过程
	 * 100 次,之后 j 的值还是等于它在循环开始之前的值,即 0
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i < 100; i++)
			j = j++; // j = ++j
		System.out.println(j); // 0
	}

}
