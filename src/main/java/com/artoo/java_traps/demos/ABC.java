package com.artoo.java_traps.demos;

public class ABC {

	/**
	 * 
	 * 在一个非空 char 数组上面调用 toString 方法会产生什么样的行为呢?数组是从 Object 那里继承的 toString 方法，
	 * 它将“返回一个字符串,它包含了该对象所属类的名字,'@'符号,以及表示对象散列码的一个无符号十六进制整数”[Java-API]。 有关
	 * Class.getName 的规范描述到:在char[]类型的类对象上调用该方法的结果为字符串"[C"。
	 * 将它们连接到一起就形成了在我们的程序中打印出来的那个丑陋的字符串。
	 * 
	 * 将一个 char 数值传递给 println 方法会打印出一个 Unicode 字符而不是它的数字代码。
	 * 字符数组受到了相同的特殊处理:println 的 char[]重载版本会打印出数组所包含的所有字符, 而String.valueOf 和
	 * StringBuffer.append 的 char[]重载版本的行为也是类似的
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String letters = "ABC";
		char[] numbers = { '1', '2', '3' };

		System.out.println(letters + " easy as " + numbers); // ABC easy as
																// [C@12ac706a
		System.out.println(numbers); // 123

		// 正解
		System.out.println(letters + " easy as " + String.valueOf(numbers));
		// 总之,char 数组不是字符串。要想将一个 char 数组转换成一个字符串,就要调用
		// String.valueOf(char[])方法。某些类库中的方法提供了对 char 数组的类似字符串的支持,通常是提供一个 Object
		// 版本的重载方法和一个 char[]版本的重载方法,而之后后者才能产生我们想要的行为。

	}

}
