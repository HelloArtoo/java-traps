package com.artoo.java_traps.demos;

public class Looper2 {

	/**
	 * 什么样的声明能够让下面的循环变成一个无限循环？
	 * 
	 * <pre>
	 * 		while (i != i) {
	 * 		}
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 浮点算术保留了一个特殊的值用来表示一个不是数字的数量，这个值就是 NaN(“不是一个数字(Not a Number)”的缩写),
		 * 对于所有没有良好的数字定义的浮点计算,例如 0.0/0.0,其值都是它。规范中描述道,NaN 不等于任何浮点数值,包括它自身在内。 NaN
		 * 还有其他的惊人之处。任何浮点操作,只要它的一个或多个操作数为 NaN, 那么其结果为
		 * NaN。这条规则是非常合理的,但是它却具有奇怪的结果。例如, 下面的程序将打印 false:
		 * 
		 * 一旦一个计算产生了 NaN,它就被损坏了, 没有任何更进一步的计算可以修复这样的损坏。NaN
		 * 值意图使受损的计算继续执行下去,直到方便处理这种情况的地方为止。
		 */

		double j = 0.0 / 0.0;
		System.out.println(j - j == 0);

		System.out.println(0.0 / 0.0);
		double i = 0.0 / 0.0; // 或者 Double.NaN
		while (i != i) {

		}

	}
}
