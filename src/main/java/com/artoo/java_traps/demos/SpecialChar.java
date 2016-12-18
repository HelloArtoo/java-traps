package com.artoo.java_traps.demos;

public class SpecialChar {

	/**
	 * 问题在于 String.replaceAll 接受了一个正则表达式作为它的第一个参数,
	 * 而并非接受了一个字符序列字面常量。正则表达式“.”可以匹配任何单个的字符,因此,类名中的每一个字符都被替换成了一个斜杠,进而产生了我们看到的输出。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(SpecialChar.class.getName().replaceAll(".", "/") // 正则
				+ ".class"); // //////////////////////////////////////.class
		
		System.out.println(SpecialChar.class.getName().replaceAll("\\.", "/") // 转义
				+ ".class");//com/artoo/java_traps/demos/SpecialChar.class
	}

}
