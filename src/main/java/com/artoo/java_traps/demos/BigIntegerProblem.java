package com.artoo.java_traps.demos;

import java.math.BigInteger;

public class BigIntegerProblem {

	/**
	 * 对此有一个很好理由可以解释:BigInteger 实例是不可变的。String、BigDecimal 以及包装器类型: Integer、
	 * Long、Short、Byte、Character、Boolean、Float 和 Double
	 * 也是如此,你不能修改它们的值。我们不能修改现有实例的值, 对这些类型的操作将返回新的实例
	 * 
	 * 不要被误导,认为不可变类型是可变的。公正地说,Java 不可变类型的某些方法名促使我们走上了歧途。像 add、subtract 和 negate
	 * 之类的名字似乎是在暗示这些方法将修改它们所调用的实例。
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger five = new BigInteger("5000");
		BigInteger fifty = new BigInteger("50000");
		BigInteger fiveHundred = new BigInteger("500000");
		BigInteger total = BigInteger.ZERO;
		total.add(five);// 不可变的
		total.add(fifty);
		total.add(fiveHundred);
		System.out.println(total); // 0

		// 正确：total = total.add(five);

	}

}
