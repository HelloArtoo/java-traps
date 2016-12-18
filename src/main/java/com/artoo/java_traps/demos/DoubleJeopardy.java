package com.artoo.java_traps.demos;

class Jeopardy {
	public static final String PRIZE = "$64,000";
}

public class DoubleJeopardy extends Jeopardy {

	public static final String PRIZE = "2 cents";

	/**
	 * 
	 * 因为在 Jeopardy 中的 PRIZE 域被声明为是 public 和 final 的,你可能会认为Java
	 * 语言将阻止你在子类中重用该域名。毕竟,final 类型的方法不能被覆写或隐藏。如果你尝试着运行该程序,就会发现它可以毫无问题地通过编译,并且将打印
	 * 2 cents。出什么错了呢? 可以证明,final 修饰符对方法和域而言,意味着某些完全不同的事情。对于方法,final
	 * 意味着该方法不能被覆写(对实例方法而言)或者隐藏(对静态方法而言。对于域,final 意味着该域不能被赋值超过一次
	 * 。关键字相同,但是其行为却完全不相关。在该程序中 final 域 DoubleJeopardy.PRIZE 隐藏了 final 域
	 * Jeopardy.PRIZE,
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(DoubleJeopardy.PRIZE); // 2 cents

		/**
		 * <pre>
		 * 如果你想保证在 Jeopardy 类中的奖金可以保留到子类中,那么你应该用一个
		 *     final 方法来代替 final 域:
		 *     class Jeopardy {
		 *          private static final String PRIZE = "$64,000";
		 *          public static final String prize() {
		 *               return PRIZE;
		 *        }
		 *     }
		 * 
		 * </pre>
		 */

	}

}
