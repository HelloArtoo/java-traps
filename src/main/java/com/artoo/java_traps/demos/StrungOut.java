package com.artoo.java_traps.demos;

public class StrungOut {

	/**
	 * VM 不能找到 main 方法是因为它并不在那里。尽管 StrungOut 有一个被命名为 main 的方法, 但是它却具有错误的签名。一个
	 * main 方法必须接受一个单一的字 符串数组参数[JVMS 5.2]。 VM 努力要告诉我们的是 StrungOut.main 接受的是由 我们的
	 * String 类所构成的数组, 它无论如何都与 java.lang.String 没有任何关 系
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 错误: 在类 com.artoo.java_traps.demos.StrungOut 中找不到主方法, 请将主方法定义为: public
		 * static void main(String[] args)
		 */
		String s = new String("Hello world");
		System.out.println(s);

		// 正解释：把下面类String改成别的 比如MyString
		// 要避免重用类名,尤其是 Java 平台类的类名。千 万不要重用 java.lang 包内的类名

	}

}

/**
 * <pre>
 * class String {
 * 	private final java.lang.String s;
 * 
 * 	public String(java.lang.String s) {
 * 		this.s = s;
 * 	}
 * 
 * 	public java.lang.String toString() {
 * 		return s;
 * 	}
 * }
 * </pre>
 * 
 */

