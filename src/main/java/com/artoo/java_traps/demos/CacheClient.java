package com.artoo.java_traps.demos;

/**
 * 考验静态化的初始顺序
 * @author Artoo
 *
 */
class Cache {
	static {
		initializeIfNecessary(); //2、 初始化，sum 会初始化默认值 0，initialized =false;然后加到4950 to 3,
	}

	private static int sum; 

	public static int getSum() {
		initializeIfNecessary();  //4、又调用一遍这时候sum已经到9900
		return sum;
	}
	
	
	//3、静态语句块执行之后，initialized从true又赋值成了false,然后走main函数中的getSum() to 4
	private static boolean initialized = false;

	private static synchronized void initializeIfNecessary() {
		if (!initialized) {
			for (int i = 0; i < 100; i++)
				sum += i;
			initialized = true;
		}

	}
}

public class CacheClient {

	/**
	 * 该程序受到了类初始化顺序问题的影响。为了理解其行为,我们来跟踪其执行过程。
	 * 在可以调用 Client.main 之前,VM 必须初始化Client 类。这项初始化工作异常简单,我们就不多说什么了。
	 * Client.main 方法调用了 Cache.getsum 方法, getsum 方法可以被执行之前, 
	 * 必须初始化 Cache VM在类类初始化是按照静态初始器在源代码中出现的顺序去执行这些初始器 回想一下, 的。
	 * Cache 类有两个静态初始器:在类顶端的一个 static 语句块,以及静态域initialized 的初始化。
	 * 静态语句块是先出现的,它调用了方法initializeIfNecessary,该方法将测试initialized 域。
	 * 因为该域还没有被赋予任何值,所以它具有缺省的布尔值 false。与此类似,sum 具有缺省的 int 值0。
	 * 因此,initializeIfNecessary 方法执行的正是你所期望的行为,将 4,950添加到了 sum 上,
	 * 并将 initialized 设置为 true在静态语句块执行之后,initialized 域的静态初始器将其设置回 false,
	 * 从而完成 Cache 的类初始化。遗憾的是,sum 现在包含的是正确的缓存值,但是initialized 
	 * 包含的却是 false:Cache 类的两个关键状态并未同步。    此后,Client 类的 main 方法调用Cache.getSum 方法,
	 * 它将再次调用initializeIfNecessary 方法。因为 initialized 标志是 false,
	 * 所以该循环将把另一个 4,950 添加到 sum initializeIfNecessary 方法将进入其循环, 上,从而使其值增加到了 9,900。
	 * getSum 方法返回的就是这个值,而程序打印的也是它。

	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * <pre>
		 * 	1、Cache执行静态块，调用initializeIfNecessary();
		 *  2、Cache初始化，会将initialized = false执行。
		 *  3、调用getSum(); sum的值相当于走了2次initializeIfNecessary();而且initialized都是false
		 * </pre>
		 * 
		 * 总之,请考虑类初始化的顺序,特别是当初始化显得很重要时更是如此。请你执行测试,以确保类初始化序列的简洁。请使用积极初始化,
		 * 除非你有某种很好的理由要使用惰性初始化,例如性能方面的因素,或者需要打破初始化循环。
		 */
		System.out.println(Cache.getSum());  // 1、   初始化Cache  to 2

	}

}
