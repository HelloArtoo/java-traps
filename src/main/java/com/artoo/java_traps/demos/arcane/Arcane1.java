package com.artoo.java_traps.demos.arcane;

import java.io.IOException;

public class Arcane1 {

	/**
	 * 第一个编译不通过 <br/>
	 * 第一个程序, 不能编译,因为 println 方法没有声明会抛出任何被检查异常,而IOException
	 * 却正是一个被检查异常。语言规范中描述道:如果一个 catch 子句要捕获一个类型为 E 的被检查异常, 而其相对应的 try 子句不能抛出 E
	 * 的某种子类型的异常,那么这就是一个编译期错误。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * try { System.out.println("Hello world"); } catch (IOException e) {
		 * System.out.println("I've never seen println fail!"); }
		 */
		// 编译报错

		/** 第一个程序说明了一项基本要求,即对于捕获被检查异常的 catch 子句, 只有在相应的 try 子句可以抛出这些异常时才被允许。 **/
	}

}
