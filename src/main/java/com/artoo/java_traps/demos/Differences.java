package com.artoo.java_traps.demos;

import java.util.HashSet;
import java.util.Set;

public class Differences {

	/**
	 * 数组中的最后一个元素以 0 开头的整数类型字面常量将被解释成为八进制数值。这个隐晦的结构是从 C 编程语言那里遗留下来东西,C 语言产生于
	 * 1970 年代,那时八进制比现在要通用得多。一旦你知道了 012 == 10,就会很清楚为什么该程序打印出了 14:有 6
	 * 个不涉及最后一个元素的唯一的非 0 差,有 7 个涉及最后一个元素的非 0 差,还有 0,加在一起正好是 14 个唯一的差
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 012 表示成了八进制 <br/>
		 * 有意识地使用八进制整型字面常量的情况相当少见,你应该对所有的这种特殊用法增加注释
		 */
		int vals[] = { 789, 678, 567, 456, 345, 234, 123, 012 };
		Set<Integer> diffs = new HashSet<Integer>();

		for (int i = 0; i < vals.length; i++)
			for (int j = i; j < vals.length; j++)
				diffs.add(vals[i] - vals[j]);

		System.out.println(diffs.size()); // 14
		// [0, 444, 446, 111, 557, 555, 224, 668, 222, 113, 666, 335, 333, 779]
		System.out.println(String.valueOf(diffs));
	}
}
