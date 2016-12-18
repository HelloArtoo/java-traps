package com.artoo.java_traps.demos;

public class AnimalFarm {

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String pig = "length: 10";
		final String dog = "length: " + pig.length();

		/**
		 * 对该程序的表面分析可能会认为它应该打印出 Animal are equal: true。毕竟, pig 和 dog 都是 final 的
		 * string 类型变量, 它们都被初始化为字符序列“length:10”。换句话说,被 pig 和 dog
		 * 引用的字符串是且永远是彼此相等的。然而,
		 * ==操作符测试的是这两个对象引用是否正好引用到了相同的对象上。在本例中,它们并非引用到了相同的对象上。那为何打印的不是“Animal
		 * are equal: false”呢？那是因为 + 操作符, 不论是用作加法还是字符串连接操作, 它都比 == 操作符的优先级高。
		 */
		System.out.println("Animals are equal:" + pig == dog); // false

		/**
		 * 在比较对象引用时,你应该优先使用 equals 方法而不是 == 操作符,除非你需要比较的是对象的标识而不是对象的值。
		 */
		System.out.println("Animals are equal:" + (pig == dog)); // Animals are
																	// equal:
																	// false
	}

}
