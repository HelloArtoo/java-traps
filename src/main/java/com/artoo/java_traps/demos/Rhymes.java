package com.artoo.java_traps.demos;

import java.util.Random;

public class Rhymes {
	private static Random rnd = new Random();

	/**
	 * 
	 * 第一个 bug 是所选取的随机数使得 switch
	 * 语句只能到达其三种情况中的两种。Random.nextInt(int)的规范描述道:“返回一个伪随机的、均等地分布在从
	 * 0(包括)到指定的数值(不包括)之间的一个 int 数值”。这意味着Switch 语句将永远也到不了 case表达式
	 * rnd.nextInt(2)可能的取值。只有 0 和 1,2 分支,这表示程序将永远不会打印 Gain。nextInt 的参数应该是 3 而不是
	 * 2。 第二个 bug 是在不同的情况(case)中没有任何 break 语句。不论 switch 表达式为何值,该程序都将执行其相对应的 case
	 * 以及所有后续的 case尽管每一个 case 都对变量 word
	 * 赋了一个值,因此但是总是最后一个赋值胜出,覆盖了前面的赋值。最后一个赋值将总是最后一种情况(default),即 new而从来不打印 Pain 或
	 * Gain。StringBuffer{'M'}。这表明该程序将总是打印 Main,在 switch 的各种情况中缺少 break
	 * 语句是非常常见的错误。 最后一个,也是最微妙的一个 bug 是表达式 new
	 * StringBuffer('M')可能没有做哪些你希望它做的事情。通过拓宽原始类型转换把字符数值'M'转换为一个 int 数值
	 * 77。换句话说,new StringBuffer('M')返回的是一个具有初始容量 77 的空的字符串缓冲区。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer word = null;
		switch (rnd.nextInt(2)) { // 只会取到 0,1，应该是rnd.nextInt(3)
		case 1:
			word = new StringBuffer('P'); // 没有break，会一直走完
			// break;
		case 2:
			word = new StringBuffer('G'); // 单引号，只是new了一个比如66大小的StringBuffer
											// ,应该换成双引号
			// break;
		default:
			word = new StringBuffer('M');
			// break;
		}

		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word); // ain

		/**
		 * 首先, 牢记在 switch 语句的每一个 case。其次, 中都放置一条 break 语句。第三,要使用常用的惯用法和 API。
		 * 第四,一个 char 不是一个 String, 而是更像一个 int。
		 */
	}

}
