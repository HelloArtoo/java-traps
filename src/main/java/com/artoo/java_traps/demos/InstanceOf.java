package com.artoo.java_traps.demos;

public class InstanceOf {

	/**
	 * 
	 * 总之,第一个程序展示了 instanceof
	 * 运行期行为的一个很有用的冷僻案例。第二个程序展示了其编译期行为的一个很有用的冷僻案例。第三个程序展示了转型操作符的行为的一个冷僻案例
	 * ,在此案例中,编译器并不能将你从你所做荒唐的事中搭救出来,只能靠 VM 在运行期来帮你绷紧这根弦
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test3();
	}

	/**
	 * false<br/>
	 * 
	 * 第一个程序, Type1, 尽管 null 对于每一个引用类型来说都是其子类型, 但是 instanceof 操作符被定义为在其左操作数为
	 * null 时返回 false。因此,Type1 将打印 false
	 */
	private static void test1() {
		String s = null;
		System.out.println(s instanceof String);
	}

	/**
	 * Exception in thread "main" java.lang.Error: Unresolved compilation
	 * problem: Incompatible conditional operand types InstanceOf and String<br/>
	 * 
	 * 第二个程序,Type2,展示了 instanceof
	 * 操作符在测试一个类的实例,以查看它是否是某个不相关的类的实例时所表现出来的行为。你可能会期望该程序打印出false。毕竟,Type2 的实例不是
	 * String 的实例,因此该测试应该失败,对吗? 不,instanceof 测试在编译时刻就失败了该程序编译失败是因为 instanceof
	 * 操作符有这样的要求:如果两个操作数的类型都是类,其中一个必须是另一个的子类型。Type2和 String 彼此都不是对方的子类型,所以
	 * instanceof 测试将导致编译期错误
	 */
	private static void test2() {
		// System.out.println(new InstanceOf() instanceof String);
	}

	/**
	 * Exception in thread "main" java.lang.ClassCastException: java.lang.Object
	 * cannot be cast to com.artoo.java_traps.demos.InstanceOf at
	 * com.artoo.java_traps.demos.InstanceOf.test3(InstanceOf.java:29)<br/>
	 * 
	 * 第三个程序,Type3,展示了当要被转型的表达式的静态类型是转型类型的超类时,转型操作符的行为。与 instanceof
	 * 操作相同,如果在一个转型操作中的两种类型都是类
	 * ,那么其中一个必须是另一个的子类型。尽管对我们来说,这个转型很显然会失败,但是类型系统还没有强大到能够洞悉表达式 new
	 * Object()的运行期类型不可能是 Type3 的一个子类型。因此,该程序将在运行期抛出ClassCastException
	 * 异常。这有一点违背直觉:第二个程序完全具有实际意义, 但是却不能编译;而这个程序没有任何实际意义,但是却可以编译。
	 */
	private static void test3() {
		InstanceOf t3 = (InstanceOf) new Object();
	}
}
