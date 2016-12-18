package com.artoo.java_traps.demos;

public class Looper3 {

	/**
	 * 什么样的声明能够让下面的循环变成一个无限循环？不能使用浮点数
	 * 
	 * <pre>
	 * 		while (i != i + 0) {
	 * 		}
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 唯一的 + 操作符有定义的非数值类型就是 String。+ 操作符被重载了:对于 String
		 * 类型,它执行的不是加法而是字符串连接。如果在连接中的某个操作数具有非 String
		 * 的类型,那么这个操作书就会在连接之前转换成字符串[。事实上,i 可以被初始化为任何值,只要它是 String 类型的即可
		 * 
		 * 总之,操作符重载是很容易令人误解的。在本谜题中的加号看起来是表示一个加法,但是通过为变量 i 选择合适的类型,即
		 * String,我们让它执行了字符串连接操作。甚至是因为变量被命名为 i,都使得本谜题更加容易令人误解,因为
		 * i通常被当作整型变量名而被保留的。对于程序的可读性来说,好的变量名、方法名和类名至少与好的注释同等重要。
		 */

		String i = "any string";
		while (i != i + 0) {

		}

		// 答案 ：只要i是任何String类型都可以。

	}
}
