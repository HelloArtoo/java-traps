package com.artoo.java_traps.demos;

public class Transitive {

	/**
	 * 请正确申明变量，使得前两个打印true，最后一个打印false
	 * <typeX> x = <valueX>;
	 * <typeY> y = <valueY>;
	 * <typeZ> z = <valueZ>;
	 * 
	 */
	public static void main(String[] args) {
		/**
		 * 当比较两个原始类型数值时,操作符 == 首先进行二进制数 据类型提升(binary numeric promotion。这
		 * 会导致这两个数值 中有一个会进行拓宽原始类型转换(widening primitive conversion)。
		 * 大部 分拓宽原始类型转换是不会有问题的,但有三个值得注意的异常情况:将 int 或 long 值转换成 float 值,
		 * 或 long 值转换成 double 值时,均会导致精度丢失
		 * 
		 * 要警惕到 float 和 double 类型的拓宽原始类型转换所造成的 损失。它们是悄无声息的,但却是致命的。
		 * 它们会违反你的直觉,并且可以造成 非常微妙的错误。更一般地说,要警惕那些混合类型的运算
		 */
		long x = Long.MAX_VALUE; 
		double y = (double) Long.MAX_VALUE;
		long z = Long.MAX_VALUE - 1;
		System.out.println((x == y) + ""); // Imprecise
		System.out.println((y == z) + ""); // Imprecise
		System.out.println(x == z); // Imprecise

	}

}
