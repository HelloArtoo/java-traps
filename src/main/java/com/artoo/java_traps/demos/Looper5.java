package com.artoo.java_traps.demos;

public class Looper5 {

	/**
	 * 什么样的声明能够让下面的循环变成一个无限循环？
	 * 
	 * <pre>
	 * while (i != 0 &amp;&amp; i == -i) {
	 * 
	 * }
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Integer.MIN_VALUE,即-2^31他的十六进制表示是 0x80000000。其符号位为 1,其余所有的位都是 0。
		 * 如果我们对这个值取负值,那么我们将得到 0x7fffffff+1,也就是 0x80000000,
		 * 即Integer.MIN_VALUE!换句话说,Integer.MIN_VALUE 是它自己的负值, Long.MIN_VALUE
		 * 也是一样。对这两个值取负值将会产生溢出,但是 Java 在整数计算中忽略了溢出。
		 * 
		 * 有符号的整数类型使用的是 2 的补码算术运算:为了对一个数值取其负值,你要反转其每一位,然后加 1,从而得到结果。 2
		 * 的补码算术运算的一个很大的优势是,0 具有唯一的表示形式。如果你要对 int 数值 0 取负值, 你将得到
		 * 0xffffffff+1,它仍然是 0。但是,这也有一个相应的不利之处,总共存在偶数个 int 数值——准确地说有232
		 * 个——其中一个用来表示 0, 这样就剩些奇数个 int 数值来表示正整数和负整数, 这意味着正的和负的 int
		 * 数值的数量必然不相等。这暗示着至少有一个 int数值,其负值不能正确地表示成为一个 int 数值。
		 */

		/**
		 * 对于每一种有符号的整数类型(int、long、byte 和 short),负的数值总是比正的数值多一个,
		 * 这个多出来的值总是这种类型所能表示的最小数值。 Integer.MIN_VALUE 取负值得对到的还是它没有改变过的值,
		 * Long.MIN_VALUE 也是如此。对 Short.MIN_VALUE取负值并将所产生的 int 数值转型回 short,
		 * 返回的同样是最初的值 (Short.MIN_VALUE)。对 Byte.MIN_VALUE 来说,也会产生相似的结果
		 */

		// 答案:Integer.MIN_VALUE 是它自己的负值, Long.MIN_VALUE
		// 也是一样。对这两个值取负值将会产生溢出,但是 Java 在整数计算中忽略了溢出。
		int i = Integer.MIN_VALUE;
		while (i != 0 && i == -i) {

		}

	}

}
