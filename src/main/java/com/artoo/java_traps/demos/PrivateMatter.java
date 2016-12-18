package com.artoo.java_traps.demos;

class Base {
	public String className = "Base";
}

class Derived extends Base {
	// 一个覆写方法的访问修饰符所提供的访问权限至少要与被覆写方法的访问修饰符所提供的访问权限相比,一样多。
	// 尽管这么做不可取的,但是它确实是合法的。事实上,对于隐藏域来说,如果它具有与被隐藏域完全无关的类型,也是合法的
	private String className = "Derived"; // 被隐藏了
}

public class PrivateMatter {

	/**
	 * 错误却出在 PrivateMatter 中。如果 className 是一个实例方法,而不是一个实例域,那么
	 * Derived.className()将覆写 Base.className(),而这样的程序是非法的。
	 * 一个覆写方法的访问修饰符所提供的访问权限至少要与被覆写方法的访问修饰符所提供的访问权限相比,一样多。因为 className 是一个域,所以
	 * Derived.className 隐藏(hide)了
	 * Base.className,而不是覆盖了它。对一个域来说,当它要隐藏另一个域时,如果隐藏域的访问修饰符提供的访问权限比被隐藏域的少
	 * ,尽管这么做不可取的,但是它确实是合法的。事实上,对于隐藏域来说,如果它具有与被隐藏域完全无关的类型,也是合法的:即使
	 * Derived.className 是GregorianCalendar 类型的,Derived 类也是合法的。 在我们的程序中的编译错误出现在
	 * PrivateMatter 类试图访问 Derived.className 的时候。尽管 Base 有一个公共域 className,但是这个域没
	 * 有被继承到 Derived 类中,因为它被 Derived.className 隐藏了。在 Derived 类内部,域名 className
	 * 引用的是私有域 Derived.className。因为这个域被声 明为是 private 的,所以它对于 PrivateMatter
	 * 来说是不可访问的。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 编译报错
		// Exception in thread "main" java.lang.Error: Unresolved compilation
		// problem:
		// The field Derived.className is not visible
		// System.out.println(new Derived().className);

		/**
		 * 隐藏通常都不是一个好主意。Java 语言允许你去隐藏变量、嵌 套类型,甚至是静态方法 但是你不能认为你
		 * 就应该去隐藏。隐藏的问题在于它将导致读者头脑的混乱。你正在使用一个被隐
		 * 藏实体,或者是正在使用一个执行了隐藏的实体吗?要避免这类混乱,只需避免 隐藏。 如果一个类要隐藏一个域,
		 * 而用来隐藏该域的域具有的可访问性比被隐藏域更具 限制性,就像我们最初的程序那样,那么这就违反了包容性(subsumption)原
		 * 则,即大家所熟知的 Liskov 置换原则(Liskov Substitution Principle)
		 * 。这项原则叙述道,你能够对基类所作的任何事,都同样能够作用于 其子类。包容性是面向对象编程的自然心理模型的一个不可分割的部分。无论何
		 * 时,只要违反了这项原则,就会对程序的理解造成困难。还有其它数种用另一个
		 * 域来隐藏某个域的方法也会违反包容性:例如,两个域具有不同的类型;一个域 是静态的而另一个域不是;一个域是 final
		 * 的而另一个域不是;一个域是常量而 另一个域不是;以及两个域都是常量但是它们具有不同的值。
		 */
	}
}
