package com.artoo.java_traps.demos;

import java.util.HashSet;
import java.util.Set;

public class Name {

	private String first, last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	/**
	 * 只要你覆写了 equals 方法,就必须同时覆写 hashCode
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Name))
			return false;

		Name n = (Name) o;
		return n.first.equals(first) && n.last.equals(last);
	}

	/**
	 * <pre>
	 * &#064;Override
	 * public int hashCode() {
	 * 	return 31 * first.hashCode() + last.hashCode();
	 * }
	 * </pre>
	 **/

	/**
	 * 这里的 bug 在于 Name 违反了 hashCode 约定。这看起来有点奇怪,因为 Name 连hashCode
	 * 都没有,但是这确实是问题所在。Name 类覆写了 equals 方法,而hashCode
	 * 约定要求相等的对象要具有相同的散列码。为了遵守这项约定,无论你何时, 只要你覆写了 equals 方法,就必须同时覆写 hashCode
	 * 方法。因为 Name 类没有覆写 hashCode 方法,所以它从 Object 那里继承了其
	 * hashCode实现。这个实现返回的是基于标识的散列码。换句话说,不同的对象几乎总是产生不相等的散列值,所以说 Name 没有遵守
	 * hashCode的约定, 即使它们是相等的也是如此。因此包含 Name 元素的散列集合的行为是不确定的。当程序将第一个 Name
	 * 实例放置到散列集合中时,该集合就会在某个散列位置上放置这个实例对应的项。该集合是基于实例的散列值来选择散列位置的,这个散列值是通过实例的
	 * hashCode 方法计算出来的。当该程序在检查第二个 Name
	 * 实例是否包含在散列集合中时,它基于第二个实例的散列值来选择要搜索的散列位置。因为第二个实例有别于第一个实例
	 * ,因此它极有可能产生不同的散列值。如果这两个散列值映射到了不同的位置,那么contains 方法将返回 false
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Name> s = new HashSet<Name>();
		s.add(new Name("Donald", "Duck"));
		System.out.println(s.contains(new Name("Donald", "Duck"))); // false
	}

	/**
	 * 总之,当你覆写 equals 方法时,一定要记着覆写 hashCode 方法。更一般地讲,
	 * 当你在覆写一个方法时,如果它具有一个通用的约定,那么你一定要遵守它。对于大多数在 Object 中声明的非 final
	 * 的方法,都需要注意这一点不采用这项建议就会导致任意的、不确定的行为。
	 * 
	 * 
	 */

}
