package com.artoo.java_traps.demos.arcane;

import com.artoo.java_traps.demos.arcane.inter.Type3;

public class Arcane3 implements Type3 {

	/**
	 * 第三个打印“Hello World”
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Type3 t3 = new Arcane3();
		t3.f();
		/**
		 * 第三个程序说明了多个继承而来的 throws 子句的交集,将减少而不是增加方法允许抛出的异常数量。本谜题所说明的行为一般不会引发难以捉摸的
		 * bug,但是你第一次看到它们时,可能会有点吃惊
		 **/
	}

	/**
	 * 第三个程序,Arcane3,看起来它也不能编译。方法 f 在 Type1 接口中声明要抛出被检查异常
	 * CloneNotSupportedException,并且在 Type2 接口中声明要抛出被检查异常
	 * InterruptedException。Type3 接口继承了 Type1 和 Type2,因此, 看起来在静态类型为 Type3
	 * 的对象上调用方法 f 时, 有潜在可能会抛出这些异常。一个方法必须要么捕获其方法体可以抛出的所有被检查异常,
	 * 要么声明它将抛出这些异常。Arcane3 的 main 方法在静态类型为 Type3 的对象上调用了方法 f,但它对
	 * CloneNotSupportedException 和 InterruptedExceptioin
	 * 并没有作这些处理。那么,为什么这个程序可以编译呢? 上述分析的缺陷在于对“Type3.f 可以抛出在 Type1.f 上声明的异常和在
	 * Type2.f 上声明的异常”所做的假设。这并不正确,因为每一个接口都限制了方法 f 可以抛出的被检查异常集合。
	 * 一个方法可以抛出的被检查异常集合是它所适用的所有类型声明要抛出的被检查异常集合的交集,而不是合集。因此,静态类 型为 Type3 的对象上的 f
	 * 方法根本就不能抛出任何被检查异常。因此,Arcane3可以毫无错误地通过编译,并且打印 Hello world。
	 */
	public void f() {
		// 一个方法可以抛出的被检查异常集合是它所适用的所有类型声明要抛出的被检查异常集合的交集,而不是合集。因此,静态类 型为 Type3
		// 的对象上的 f
		// 方法根本就不能抛出任何被检查异常。
		System.out.println("Hello world");

	}
}
