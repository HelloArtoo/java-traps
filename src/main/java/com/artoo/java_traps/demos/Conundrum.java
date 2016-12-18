package com.artoo.java_traps.demos;

/**
 * 请为Enigma 提供一个声明,它可以使该程序打印 false但不能覆写 equals 方法
 * 
 * <pre>
 * Enigma e = new Enigma();
 * System.out.println(e.equals(e));
 * </pre>
 * 
 * @author Administrator
 * 
 */
public class Conundrum {

	/**
	 * 乍一看,这似乎不可能实现。因为 Object.equals 方法将测试对象的同一性,通 过 Enigma 传递给 equals
	 * 方法的对象肯定是与其自身相同的。如果你不能覆写 Object.equals 方法,那么 main 方法必然打印 true,对吗?
	 * 别那么快下结论。尽管本谜题禁止你覆写(override)Object.equals 方 法,但是你是可以重载(overload)它的
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Enigma e = new Enigma();
		System.out.println(e.equals(e));
	}

}

final class Enigma {
	// 不覆写，但是可以重载啊
	// 正解
	/**
	 * <pre>
	 * public boolean equals(Enigma e) {
	 * 	// TODO Auto-generated method stub
	 * 	return false;
	 * }
	 * </pre>
	 * 
	 * 如果你重载了一个方法,那 么一定要确保所有的重载版本行为一致
	 */

}
