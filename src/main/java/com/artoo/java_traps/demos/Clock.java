package com.artoo.java_traps.demos;

public class Clock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 问题在于那个布尔表达式(ms % 60*1000 == 0)。你可能会认为这个表达式等价于(ms % 60000 ==
		 * 0),但是它们并不等价。取余和乘法操作符具有相同的优先级[JLS 15.17],因此表达式 ms % 60*1000 等价于(ms %
		 * 60)*1000。如果(ms %60)等于 0 的话,这个表达式就等于 0,因此循环每 60 次迭代就对 minutes
		 * 执行增量操作。这使得最终的结果相差 1000 倍。
		 */
		int minutes = 0;
		for (int ms = 0; ms < 60 * 60 * 1000; ms++)
			if (ms % 60 * 1000 == 0)
				minutes++;
		System.out.println(minutes); // 60000

		// 正确应该是：if (ms % (60 * 1000) == 0),在不能确定优先级的时候优先考虑括号。

	}

}
