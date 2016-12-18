package com.artoo.java_traps.demos;

public class LongDivision {

	/**
	 * <pre>
	 * 问题在于常数 MICROS_PER_DAY 的计算“确实”溢出了（整形最大值2147483647，而结果为86400000000）。
	 * 尽管计算的结果适合放入 long 中,并且其空间还有富余,但是这个结果并不适合放入 int 中。
	 * 这个计算完全是以 int 运算来执行的,并且只有在运算完成之后,其结果才被提升到long,而此时已经太迟了:计算已经溢出了,它返回的是一个小了 200 倍的数值（ 500654080 ）。
	 * 从 int 提升到 long 是一种拓宽原始类型转换 (widening primitive conversion)  ,它保留了(不正确的)数值。
	 * 这个值之后被 MILLIS_PER_DAY 整除,而MILLIS_PER_DAY 的计算是正确的,因为它适合 int 运算。这样整除的结果就得到了 5。
	 * 那么为什么计算会是以 int 运算来执行的呢?因为所有乘在一起的因子都是 int数值。当你将两个 int 数值相乘时,你将得到另一个 int 数值。
	 * 
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000; // 微妙 (溢出了)
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000; // 毫秒

		// 每天的毫秒数整除每天的微秒数。
		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY); // 结果：5

		/**
		 * 通过使用 long 常量来替代 int 常量作为每一个乘积的第一个因子,我们就可以很容易地订正这个程序。
		 * 这样做可以强制表达式中所有的后续计算都用 long 运作来完成。尽管这么做只在 MICROS_PER_DAY 表达式中是必需的,
		 * 但是在两个乘积中都这么做是一种很好的方式。相似地,使用 long 作为乘积的“第一个”数值也并不总是必需的,
		 * 但是这么做也是一种很好的形式。在两个计算中都以 long数值开始可以很清楚地表明它们都不会溢出。
		 * 
		 * 这个教训很简单:当你在操作很大的数字时,千万要提防溢出——它可是一个缄默杀手。
		 * 即使用来保存结果的变量已显得足够大,也并不意味着要产生结果的计算具有正确的类型。 当你拿不准时,就使用 long 运算来执行整个计算。
		 */
		final long MICROS_PER_DAY_RIGHT = 24L * 60 * 60 * 1000 * 1000; // 微妙
		final long MILLIS_PER_DAY_RIGHT = 24L * 60 * 60 * 1000; // 毫秒，
																// 这个没溢出，也可以不加L
		System.out.println(MICROS_PER_DAY_RIGHT / MILLIS_PER_DAY_RIGHT); // 结果1000
	}

}
