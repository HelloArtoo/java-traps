package com.artoo.java_traps.demos;

public class Looper4 {

	/**
	 * 什么样的声明能够让下面的循环变成一个无限循环？
	 * <pre>
	 * 		while (i <= j && j <= i && i != j) {
	 * 		}
	 * </pre>
	 * @param args
	 */
	public static void main(String[] args) {
		// 答案：
		Integer i = new Integer(0);
		Integer j = new Integer(0);
		while (i <= j && j <= i && i != j) { // 前两个解包装，后面比较的是对象

		} //算数运算相等，值运算不等
		/**
		 * 前两个子表达式(i <= j 和 j <= i)在 i 和 j 上执行解包转换并且在数字上比较所产生的 int 数值。i 和 j 都表示
		 * 0,所以这两个子表达式都被计算为 true。第三个子表达式(i != j)在对象引用 i 和 j 上执行标识比较,
		 * 因为它们都初始化为一个新的 Integer 实例,因此,第三个子表达式同样也被计算为 true,循环也就永远地环绕下去了。
		 * 
		 * 总之,当两个操作数都是被包装的数字类型时,数值比较操作符和判等操作符的行为存在着根本的差异:数值比较操作符执行的是值比较,
		 * 而判等操作符执行的是引用标识的比较。
		 */
	}

}
