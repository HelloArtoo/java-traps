package com.artoo.java_traps.demos;

import java.util.HashMap;
import java.util.Map;

public class MoreNames {

	private Map<String, String> m = new HashMap<String, String>();

	public void MoreNames() { //此处不是构造方法
		m.put("Mickey", "Mouce");
		m.put("Mickey", "Mantle");
	}

	public int size() {
		return m.size();
	}

	/**
	 * 不要因为偶然地添加了一个返回类型,而将一个构造器声明变成了一个方法声明。尽管一个方法的名字与声明它的类的名字相同是合法的,但是你千万不要这么做。
	 * 更一般地讲,要遵守标准的命名习惯,它强制要求方法名必须以小写字母开头,而类名应该以大写字母开头。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new MoreNames().size()); // 0

	}

}
