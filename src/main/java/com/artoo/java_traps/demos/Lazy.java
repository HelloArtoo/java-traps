package com.artoo.java_traps.demos;

public class Lazy {

	private static boolean initialized = false;
	/**
	 * 正解 ：
	 * 
	 * <pre>
	 * private static Thread t = new Thread(new Runnable() {
	 * 
	 * 	public void run() {
	 * 		initialized = true;
	 * 
	 * 	}
	 * });
	 * static {
	 * 	t.start();
	 * }
	 * </pre>
	 **/

	static {
		Thread t = new Thread(new Runnable() {

			public void run() {
				initialized = true;

			}
		});
		t.start();

		try {
			t.join();
		} catch (InterruptedException e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * <pre>
	 * 为了理解这个程序的行为,我们需要模拟它初始化的细节。当一个线程访问一个
	 *     类的某个成员的时候,它会去检查这个类是否已经被初始化。在忽略严重错误的
	 *     情况下,有 4 种可能的情况：
	 *        1   这个类尚未被初始化。
	 *        2   这个类正在被当前线程初始化:这是对初始化的递归请求。
	 *        3   这个类正在被其他线程而不是当前线程初始化。
	 *        4   这个类已经被初始化。
	 *     当主线程调用 Lazy.main 方法时,它会检查 Lazy 类是否已经被初始化。此时它 并没有被初始化(情况 1),
	 *     所以主线程会记录下当前正在进行初始化,并开始对 这个类进行初始化。按照我们前面的分析,主线程会将 initialized 的值设为 false,
	 *     创建并启动一个后台线程,该线程的 run 方法会将 initialized 设为 true,然后主线程会等待后台线程执行完毕。
	 *     此时,有趣的事情开始了。 那个后台线程调用了它的 run 方法。在该线程将 Lazy.initialized 设为 true 之前,
	 *     它也会去检查 Lazy 类是否已经被初始化。这个时候,这个类正在被另外 一个线程进行初始化(情况 3)。在这种情况下,当前线程,
	 *     也就是那个后台线 程,会等待 Class 对象直到初始化完成。遗憾的是,那个正在进行初始化工作的 线程,也就是主线程,正在等待着后台线程运行结束。
	 *     因为这 2 个线程现在正相 互等待着,该程序就死锁了(deadlock)。这就是所有的一切,真是遗憾。
	 * </pre>
	 * 
	 * 
	 * 总之,在类的初始化期间等待某个后台线程很可能会造成死锁。要让类初始化的动作序列尽可能地简单
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(initialized);// 不能打印任何东西，程序被挂起

		/**
		 * 正解 ：
		 * 
		 * <pre>
		 * try {
		 * 	t.join();
		 * } catch (InterruptedException e) {
		 * 	throw new AssertionError(e);
		 * }
		 * System.out.println(initialized);
		 * </pre>
		 **/
	}

}
