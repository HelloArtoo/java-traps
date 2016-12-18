package com.artoo.java_traps.demos;

import java.math.BigDecimal;

/**
 * Double 精度问题
 * 
 * @author Administrator
 * 
 */
public class DoublePrecision {

	/**
	 * <pre>
	 * 这个数字不能被精确表示成为一个 double,因此它被表示成为最接近它的 double 值。 该程序从 2
	 * 中减去的就是这个值。遗憾的是,这个计算的结果并不是最接近 0.9 的 double 值。作为结果的 double
	 * 值的最短表示就是你所看到的打印出来的那个可恶的数字。 更一般地说,问题在于并不是所有的小数都可以用二进制浮点数来精确表示的。
	 * 浮点运算在一个范围很广的 值域上提供了很好的近似,但是它通常不能产生精确的结果。 二进制浮点对于货币计算是非常不适合的, 因为它不可能将
	 * 0.1或者 10 的其它任何次负幂精确表示为一个长度有限的二进制小数。
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(2.0 - 1.10); // 0.8999999999999999

		/**
		 * 解决该问题的一种方式是使用执行精确小数运算的 BigDecimal。它还可以通过 JDBC 与SQL DECIMAL 类型进行互操作。
		 * 这里要注意一点: 一定要用BigDecimal(String)构造器,而千万不要用 BigDecimal(double)。
		 * 后一个构造器将用它的参数的“精确”值来创建一个实例:new BigDecimal(.1)将返回一个BigDecimal也即0
		 * .100000000000000055511151231257827021181583404541015625 正确使用
		 * BigDecimal,程序就可以打印出我们所期望的结果 0.90
		 * 
		 * 总之, 在需要精确答案的地方,要避免使用 float 和 double;对于货币计算, 要使用 int、long 或BigDecimal。
		 */
		System.out.println(new BigDecimal("2.0")
				.subtract(new BigDecimal("1.10"))); // 0.90
	}
}
