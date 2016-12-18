package com.artoo.java_traps.demos;

public class LastLaugh {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("H" + "a"); // Ha
		/**
		 * 正如我们所期望的,第一个对 System.out.print 的调用打印的是
		 * Ha:它的参数是表达式"H"+"a",显然它执行的是一个字符串连接。而第二个对System.out.print
		 * 的调用就是另外一回事了。问题在于'H'和'a'是字符型字面常量,因为这两个操作数都不是字符串类型的,所以 +
		 * 操作符执行的是加法而不是字符串连接。
		 * 
		 * <pre>
		 * 如果要连接的没有一个数值是字符串类型的,那么你可以有几种选择: 
		 * 1 预置一个空字符串; System.out.println("" +'H' + 'a'); 
		 * 2 将第一个数值用 String.valueOf 显式地转换成一个字符串;
		 * 3 使用一个字符串缓冲区; 
		 * 4或者如果你使用的 JDK 5.0,可以用 printf 方法。
		 * </pre>
		 * 
		 * 总之,使用字符串连接操作符使用格外小心。+ 操作符当且仅当它的操作数中至少有一个是 String
		 * 类型时,才会执行字符串连接操作;否则,它执行的就是加法。
		 */
		System.out.println('H' + 'a'); // 169
		//优先级问题，加括号
		System.out.println(" 2 + 2 = " + 2 + 2); // 2 + 2 = 22 
	}

}
