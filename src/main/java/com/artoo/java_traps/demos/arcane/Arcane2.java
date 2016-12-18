package com.artoo.java_traps.demos.arcane;

public class Arcane2 {

	/**
	 * 第二个编译通过，但永远什么都不会打印<br/>
	 * 基于同样的理由,第二个程序,Arcane2,看起来应该是不可以编译的,但是它却可以。它之所以可以编译,是因为它唯一的 catch 子句检查了
	 * Exception。尽管 JLS 在这一点上十分含混不清,但是捕获 Exception 或 Throwble 的 catch
	 * 子句是合法的,不管与其相对应的 try 子句的内容为何。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/** 第二个程序说明了这项要求不会应用到的冷僻案例。**/
		try {
			// donothing
		} catch (Exception e) {
			System.out.println("This can't happen");
		}
	}

}
