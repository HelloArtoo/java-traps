package com.artoo.java_traps.demos;

class TheDog {
	public static void bark() {
		System.out.println("woof ");
	}
}

class TheBasenji extends TheDog {
	public static void bark() {
	}
}

public class Bark {

	/**
	 * 问题在于 bark
	 * 是一个静态方法,而对静态方法的调用不存在任何动态的分派机制。当一个程序调用了一个静态方法时,要被调用的方法都是在编译时刻被选定的
	 * ,而这种选定是基于修饰符的编译期类型而做出的
	 * ,修饰符的编译期类型就是我们给出的方法调用表达式中圆点左边部分的名字。在本案中,两个方法调用的修饰符分别是变量 woofer 和
	 * nipper,它们都被声明为
	 * Dog类型。因为它们具有相同的编译期类型,所以编译器使得它们调用的是相同的方法:Dog.bark。这也就解释了为什么程序打印出 woof
	 * woof。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TheDog woofer = new TheDog();
		TheDog nipper = new TheBasenji();
		woofer.bark(); // woof
		nipper.bark(); // woof
		// 静态方法，编译器 类型做出的，编译期都觉得是 TheDog，所有调用TheDog里面定义的bark()
		// 而静态方法是不能被覆写的;它们只能被隐藏

		/**
		 * 当你调用了一个静态方法时,通常都是用一个类而不是表达式来标识它:例如, Dog.bark 或 Basenji.bark。 当你在阅读一个
		 * Java 程序时,你会期望类被用作为静态方法的修饰符,这些静态方法都是被静态分派的,而表达式被用作为实例方法的修饰符,
		 * 这些实例方法都是被动态分派的
		 * 。通过耦合类和变量的不同的命名规范,我们可以提供一个很强的可视化线索,用来表明一个给定的方法调用是动态的还是静态的。
		 * 本谜题的程序使用了一个表达式作为静态方法调用的修饰符, 这就误导了我们。千万不要用一个表达式来标识一个静态方法调用。
		 * 覆写的使用与上述的混乱局面搅到了一起。Basenji 中的 bark 方法与 Dog 中的bark 方法具有相同的方法签名,
		 * 这正是覆写的惯用方式,预示着要进行动态的分派。然而在本案中,该方法被声明为是 static 的,而静态方法是不能被覆写的;
		 * 它们只能被隐藏,而这仅仅是因为你没有表达出你应该表达的意思。为了避免这样的混乱,千万不要隐藏静态方法。
		 * 即便在子类中重用了超类中的静态方法的名称,也不会给你带来任何新的东西,但是却会丧失很多东西。
		 * 
		 * 正确应该去掉static
		 */

	}

}
