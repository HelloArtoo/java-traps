package com.artoo.java_traps.demos;

public class Reluctant {
	private Reluctant internalInstance = new Reluctant();

	public Reluctant() throws Exception {
		throw new Exception("I'am not coming out.");
	}

	/**
	 * 
	 * 与大多数抛出 StackOverflowError
	 * 异常的程序一样,本程序也包含了一个无限递归。当你调用一个构造器时,实例变量的初始化操作将先于构造器的程序体而运行。在本谜题中,
	 * internalInstance 变量的初始化操作递归调用了构造器,而该构造器通过再次调用 Reluctant
	 * 构造器而初始化该变量自己的internalInstance 域,如此无限递归下去。这些递归调用在构造器程序体获得执行机会之前就会抛出
	 * StackOverflowError 异常,因为 StackOverflowError是 Error 的子类型而不是 Exception
	 * 的子类型,所以 catch 子句无法捕获它。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Reluctant b = new Reluctant();
			System.out.println("Surprice!");

		} catch (Exception ex) {
			System.out.println("I told you so");
		}

		/*
		 * Exception in thread "main" java.lang.StackOverflowError at
		 * com.artoo.java_traps.demos.Reluctant.<init>(Reluctant.java:6) at
		 * com.artoo.java_traps.demos.Reluctant.<init>(Reluctant.java:4) at
		 * com.artoo.java_traps.demos.Reluctant.<init>(Reluctant.java:4) at
		 * com.artoo.java_traps.demos.Reluctant.<init>(Reluctant.java:4)
		 */

		/**
		 * 正解：注释掉 private Reluctant internalInstance = new Reluctant();
		 * 
		 * 总之,实例初始化操作是先于构造器的程序体而运行的
		 * 。实例初始化操作抛出的任何异常都会传播给构造器。如果初始化操作抛出的是被检查异常,那么构造器必须声明也会抛出这些异常
		 * ,但是应该避免这样做,因为它会造成混乱。
		 */
	}

}
