package com.artoo.java_traps.demos;

public class Indecisive {

	/**
	 * finally 语句块总是在控制权离开 try 语句块时执行的[JLS 14.20.2]。无论 try 语句块是正常结束的,还是意外结束的,
	 * 情况都是如此。一条语句或一个语句块在它抛出了一个异常,或者对某个封闭型语句执行了一个 break 或
	 * continue,或是象这个程序一样在方法中执行了一个return
	 * 时,将发生意外结束。它们之所以被称为意外结束,是因为它们阻止程序去按顺序执行下面的语句。在这个程序中,在 try 语句块中的 return
	 * 语句所引发的意外结束将被丢弃, try-finally 语句意外结束是由 finally 语句块中的 return而造成的。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(decision());

		/**
		 * 总之,每一个 finally 语句块都应该正常结束,除非抛出的是不受检查的异常。千万不要用一个 return、 break、
		 * continue 或 throw 来退出一个 finally 语句块, 并且千万不要允许将一个受检查的异常传播到一个 finally
		 * 语句块之外去。
		 */
		System.out.println(decision2());
	}

	/**
	 * 结果：a
	 * 
	 * @return
	 */
	static String decision() {
		String s = "a";
		try {
			return s;
		} finally {
			s = s.toUpperCase(); // 转换成大写
		}
	}

	/**
	 * 结果：A
	 * 
	 * @return
	 */
	static String decision2() {
		String s = "a";
		try {
			return s;
		} finally {
			return s.toUpperCase(); // 加个return
		}
	}

}
