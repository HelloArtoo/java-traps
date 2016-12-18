package com.artoo.java_traps.demos;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reflector {

	/**
	 * 这是怎么发生的呢?正如这个异常所显示的,hasNext
	 * 方法当然是公共的,所以它在任何地方都是可以被访问的。那么为什么这个基于反射的方法调用是非法的呢?这里的问题并不在于该方法的访问级别(access
	 * level),而在于该方法所在的类型的访问级别。这个类型所扮演的角色和一个普通方法调用中的限定类型 (qualifying
	 * type)是相同的[JLS 13.1]。在这个程序中,该方法是从某个类中选择出来的,而这个类型是由从 it.getClass 方法返回的
	 * Class 对象表示的。这是迭代器的动态类型 (dynamic type) 它恰好是私有的嵌套类(nested
	 * class),java.util.HashMap.KeyIterator。出现 IllegalAccessException
	 * 异常的原因就是这个类不是公共的
	 * ,它来自另外一个包:访问位于其他包中的非公共类型的成员是不合法的。无论是一般的访问还是通过反射的访问,上述的禁律都是有效的
	 * 。下面这段没有使用反射的程序也违反了这条规则。
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Set<String> s = new HashSet<String>();
		s.add("foo");
		Iterator it = s.iterator();
		Method m = it.getClass().getMethod("hasNext");
		// 正解
		// Method m = Iterator.class.getMethod("hasNext");
		System.out.println(m.invoke(it));
		/**
		 * Exception in thread "main" java.lang.IllegalAccessException: Class
		 * com.artoo.java_traps.demos.Reflector can not access a member of class
		 * java.util.HashMap$HashIterator with modifiers "public final" at
		 * sun.reflect.Reflection.ensureMemberAccess(Unknown Source) at
		 * java.lang.reflect.AccessibleObject.slowCheckMemberAccess(Unknown
		 * Source) at java.lang.reflect.AccessibleObject.checkAccess(Unknown
		 * Source) at java.lang.reflect.Method.invoke(Unknown Source) at
		 * com.artoo.java_traps.demos.Reflector.main(Reflector.java:18)
		 * 
		 * 总之,访问其他包中的非公共类型的成员是不合法的,即使这个成员同时也被声
		 * 明为某个公共类型的公共成员也是如此。不论这个成员是否是通过反射被访问 的,上述规则都是成立的。这个问题很有可能只在反射访问中才会出现。
		 */

	}

}
