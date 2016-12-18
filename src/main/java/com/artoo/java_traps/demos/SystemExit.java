package com.artoo.java_traps.demos;

public class SystemExit {

	/**
	 * 然而在这个程序中,try 语句块根本就没有结束其执行过程。System.exit 方法将停止当前线程和所有其他当场死亡的线程。finally
	 * 子句的出现并不能给予线程继续去执行的特殊权限。
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Hello world"); // Hello world
			System.exit(0);
		} finally {
			System.out.println("Goodbye world"); // 不会打印
		}

		/**
		 * <pre>
		 * 当 System.exit 被调用时,虚拟机在关闭前要执行两项清理工作。首先,它执行
		 * 所有的关闭挂钩操作,这些挂钩已经注册到了 Runtime.addShutdownHook 上。这
		 * 对于释放 VM 之外的资源将很有帮助。               务必要为那些必须在 VM 退出之前发生的行
		 * 为关闭挂钩。下面的程序版本示范了这种技术,它可以如我们所期望地打印出
		 * Hello world 和 Goodbye world:
		 * public class HelloGoodbye1 {
		 * 	public static void main(String[] args) {
		 * 		System.out.println("Hello world");
		 * 		Runtime.getRuntime().addShutdownHook(
		 * 					  new Thread() {
		 * 					 public void run() {
		 * 						 System.out.println("Goodbye world");
		 * 				 }
		 * 			 });
		 * 		System.exit(0);
		 * 	}
		 * }
		 * VM 执行在 System.exit 被调用时执行的第二个清理任务与终结器有关。如果
		 * System.runFinalizerOnExit 或它的魔鬼双胞胎 Runtime.runFinalizersOnExit
		 * 被调用了,那么 VM 将在所有还未终结的对象上面调用终结器。这些方法很久以
		 * 前就已经过时了,而且其原因也很合理。无论什么原因,永远不要调用
		 * System.runFinalizersOnExit 和 Runtime.runFinalizersOnExit:  它们属于 Java
		 * 类库中最危险的方法之一[ThreadStop]。调用这些方法导致的结果是,终结器会  
		 *  从而导致不确定的行为或导致死
		 * 在那些其他线程正在并发操作的对象上面运行,
		 * 锁。
		 * 
		 * </pre>
		 */

		/**
		 * 总之,System.exit 将立即停止所有的程序线程,它并不会使 finally 语句块得到调用,但是它在停止 VM
		 * 之前会执行关闭挂钩操作。当 VM 被关闭时,请使用关闭挂钩来终止外部资源。 通过调用 System.halt
		 * 可以在不执行关闭挂钩的情况下停止 VM,但是这个方法很少使用
		 */

	}
}
