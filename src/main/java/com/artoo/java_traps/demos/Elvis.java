package com.artoo.java_traps.demos;

import java.util.Calendar;

public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	private final int beltSize;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(
			Calendar.YEAR); //放在第一行先初始化

	public Elvis() {
		beltSize = CURRENT_YEAR - 1930;
	}

	/**
	 * 该程序所遇到的问题是由类初始化顺序中的循环而引起的。让我们来看看其细节。Elvis 类的初始化是由虚拟机对其 main
	 * 方法的调用而触发的。首先,其静态域被设置为缺省值其中 INSTANCE 域被设置为 null, CURRENT_YEAR 被设置为
	 * 0。接下来,静态域初始器按照其出现的顺序执行。第一个静态域是 INSTANCE,它的值是通过调用
	 * Elvis()构造器而计算出来的。这个构造器会用一个涉及静态域 CURRENT_YEAR 的表达式来初始化
	 * beltSize。通常,读取一个静态域是会引起一个类被初始化的事件之一,但是我们已经在初始化 Elvis 类了。
	 * 递归的初始化尝试会直接被忽略掉,第 3 步。因此, CURRENT_YEAR 的值仍旧是其缺省值 0。这就是为什么 Elvis
	 * 的腰带尺寸变成了-1930 的原因。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 总之,要当心类初始化循环。最简单的循环只涉及到一个单一的类,但是它们也可能涉及多个类。类初始化循环也并非总是坏事,
		 * 但是它们可能会导致在静态域被初始化之前就调用构造器。静态域,甚至是 final 类型的静态域,可能会在它们被初始化之前,被读走其缺省值。
		 */
		System.out
				.println("Elvis wears a size " + INSTANCE.beltSize + " belt.");
		// print: Elvis wears a size -1930 belt.

	}

}
