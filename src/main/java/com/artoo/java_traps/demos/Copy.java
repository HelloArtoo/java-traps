package com.artoo.java_traps.demos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 总之,当你在 finally 语句块中调用 close 方法时,要用一个嵌套的 try-catch语句来保护它,以防止 IOException
 * 的传播。更一般地讲,对于任何在 finally语句块中可能会抛出的被检查异常都要进行处理,而不是任其传播。
 * 
 * @author Administrator
 * 
 */
public class Copy {
	static void copy_N(String src, String dist) throws IOException {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dist);
			byte[] buffer = new byte[1024];
			int n;
			while ((n = in.read(buffer)) > 0) {
				out.write(buffer, 0, n);
			}
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}

	}

	static void copy_Y(String src, String dist) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dist);
			byte[] buffer = new byte[1024];
			int n;
			while ((n = in.read(buffer)) > 0) {
				out.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// nothing we can do
				}
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// nothing we can do
				}
		}

	}

	/**
	 * 问题在 finally 语句块自身中。close 方法也可能会抛出 IOException 异常。如果这正好发生在 in.close
	 * 被调用之时,那么这个异常就会阻止 out.close 被调用,从而使输出流仍保持在开放状态。请注意,该程序违反了谜题 36 的建议:对 close
	 * 的调用可能会导致 finally 语句块意外结束。遗憾的是,编译器并不能帮助你发现此问题,因为 close 方法抛出的异常与 read 和
	 * write 抛出的异常类型相同,而其外围方法(copy)声明将传播该异常。
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String[] args2 = { "D://Test.class", "D://Test334.class" };
		args = args2;
		if (args.length != 2)
			System.err.println("Usage: java Copy <Source> <dest>");
		else
			copy_N(args[0], args[1]);// copy_Y(args[0], args[1]);

		// 打印：Usage: java Copy <source> <dest>,注意流关闭的问题

	}

}
