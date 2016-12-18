package com.artoo.java_traps.demos;

public class StringCheese {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte bytes[] = new byte[256];
		for (int i = 0; i < 256; i++)
			bytes[i] = (byte) i;

		/**
		 * 这里的罪魁祸首就是 String(byte[])构造器。有关它的规范描述道:“在通过解码使用平台缺省字符集的指定 byte
		 * 数组来构造一个新的 String 时,该新String 的长度是字符集的一个函数,因此,它可能不等于 byte
		 * 数组的长度。当给定的所有字节在缺省字符集中并非全部有效时,这个构造器的行为是不确定的
		 */
		String str = new String(bytes); // 注意这一步,依赖平台的字符集
		int n = str.length();
		for (int i = 0; i < n; i++)
			System.out.println((int) str.charAt(i) + " "); // 65533 ...

		/**
		 * 
		 * 每当你要将一个 byte 序列转换成一个 String
		 * 时,你都在使用某一个字符集,不管你是否显式地指定了它。如果你想让你的程序的行为是可预知的,那么就请你在每次使用字符集时都明确地指定。
		 * 
		 * 正解：String str = new String(bytes,"ISO-8859-1");
		 */
	}
}
