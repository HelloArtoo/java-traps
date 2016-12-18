package com.artoo.java_traps.demos;

import java.util.HashSet;
import java.util.Set;

public class Name2 {

	private String first, last;

	public Name2(String first, String last) {
		this.first = first;
		this.last = last;
	}

	/**
	 * 此处不是覆盖，是重载了equals方法<br/>
	 * 参考Name.java的覆盖
	 */
	public boolean equals(Name2 n) {
		return n.first.equals(first) && n.last.equals(last);
	}

	@Override
	public int hashCode() {
		return 31 * first.hashCode() + last.hashCode();
	}

	/**
	 * 在本谜题中,Name 覆写了 hashCode 方法,但是没有覆写 equals 方法。这并不是说 Name 没有声明一个 equals 方法,
	 * 它确实声明了,但是那是个错误的声明。Name 类声明了一个参数类型是 Name 而不是 Object 的 equals
	 * 方法。这个类的作者可能想要覆写 equals 方法,但是却错误地重载了它
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Name2> s = new HashSet<Name2>();
		s.add(new Name2("Donald", "Duck"));
		System.out.println(s.contains(new Name2("Donald", "Duck"))); // false
	}

	/**
	 * 当你想要进行覆写时,千万不要进行重载。为了避免无意识地重载,你应该机械地对你想要覆写的每一个超类方法都拷贝其声明,或者更好的方式是让你的 IDE
	 * 帮你去做这些事。这样做除了可以保护你免受无意识的重载之害, 而且还可以保护你免受拼错方法名之害。
	 * 
	 */

}
