package com.artoo.java_traps.demos;

public class DosEquis {

	/**
	 * <pre>
	 * 请注意在这两个表达式中,每一个表达式的第二个和第三个操作数的类型都不相同。混合类型的计算会引起混乱,而这一点比在条件表达式中比在其它任何地方都表现得更明显。
	 * 确定条件表达式结果类型的规则比较复杂但其核心就是以下三点:
	 * 1）如果第二个和第三个操作数具有相同的类型, 那么它就是条件表达式的类型。
	 * 2）如果一个操作数的类型是 T,T 表示 byte、short 或 char,而另一个操作数是一个 int 类型的常量表达式,它的值是可以用类型 T 表示的,那么条件表达式的类型就是 T。
	 *  3）否则,将对操作数类型运用二进制数字提升,而条件表达式的类型就是第二个和第三个操作数被提升之后的类型。
	 *  
	 *     2、3 两点对本谜题是关键。在程序的两个条件表达式中,一个操作数的类型是char,另一个的类型是 int。在两个表达式中,int 操作数都是 0,
	 * 	它可以被表示成一个 char。然而,只有第一个表达式中的 int 操作数是常量(0),而第二个表达式中的 int 操作数是变量(i)。
	 * 	因此,第 2 点被应用到了第一个表达式上,它返回的类型是char,而第 3 点被应用到了第二个表达式上,其返回的类型是对 int 和 char 运用了二进制数字提升之后的类型,即 int。
	 * 	条件表达式的类型将确定哪一个重载的 print 方法将被调用。对第一个表达式来说,PrintStream.print(char)将被调用,而对第二个表达式来说, PrintStream.print(int)将被调用。
	 * 	前一个重载方法将变量 x 的值作为 Unicode字符(X)来打印,而后一个重载方法将其作为一个十进制整数(88)来打印。
	 * 
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char x = 'X';
		int i = 0;
		System.out.println(true ? x : 0); // X
		System.out.println(false ? i : x); // 88

		/**
		 * 将final修饰符用于i的生命可以把i转变为一个常量表达式，从而让程序答应XX，但是这仍旧会引起混乱。为了消灭这种混乱，
		 * 最好还是讲i的类型从int更改为char，以避免混合类型的计算。
		 * 
		 * 总之,通常最好是在条件表达式中使用类型相同的第二和第三操作数。否则,你和你的程序的读者必须要彻底理解这些表达式行为的复杂规范。
		 */
		final int j = 0;
		System.out.println(false ? j : x); // X
	}

}
