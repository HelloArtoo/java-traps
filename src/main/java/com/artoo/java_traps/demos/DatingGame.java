package com.artoo.java_traps.demos;

import java.util.Calendar;
import java.util.Date;

public class DatingGame {

	/**
	 * 该程序的第一个 bug 就位于方法调用 cal.set(1999,12,31)中。当月份以数字来表示时,习惯上我们将第一个月被赋值为
	 * 1。遗憾的是,Date 将一月表示为 0, 而 Calendar 延续了这个错误。因此,这个方法调用将日历设置到了 1999 年第13 个月的第
	 * 31 天。但是标准的(西历)日历只有 12 个月,该方法调用肯定应该抛出一个 IllegalArgumentException
	 * 异常,对吗?它是应该这么做,但是它并没有这么做。Calendar 类直接将其替换为下一年,在本例中即 2000
	 * 年的第一个月。这也就解释了我们的程序为什么打印出的第一个数字是 2000。该程序打印出的第二个数字又是怎么回事呢? Date.getDay
	 * 返回的是 Date实例所表示的星期日期,而不是月份日期。这个返回值是基于 0 的,从星期天开始计算。因此程序所打印的 1 表示 2000 年 1
	 * 月 31 日是星期一
	 * 
	 * 
	 * 本谜题只是掀开了 Calendar 和 Date 缺陷的冰山一角。这些 API 简直就是雷区。Calendar
	 * 其他的严重问题包括弱类型(几乎每样事物都是一个 int)、过于复杂的状态空间、拙劣的结构、不一致的命名以及不一致的雨衣等。在使用
	 * Calendar和 Date 的时候一定要当心,千万要记着查阅 API 文档。
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// 当月份以数字来表示时,习惯上我们将第一个月被赋值为 1。遗憾的是,Date 将一月表示为 0
		cal.set(1999, 12, 31);
		// 正解
		// cal.set(1999, Calendar.DECEMBER, 31);
		System.out.println(cal.get(Calendar.YEAR) + " "); // 2000

		Date d = cal.getTime();
		// Date.getDay 返回的是 Date实例所表示的星期日期，而不是月份日期
		System.out.println(d.getDay()); // 1
		// 正解:
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));

	}
}
