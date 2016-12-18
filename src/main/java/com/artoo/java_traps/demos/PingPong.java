package com.artoo.java_traps.demos;

public class PingPong {

	/**
	 * 在多线程程序中,通常正确的观点是程序每次运行的结果都有可能发生变化,但
	 * 是上面这段程序总是打印出相同的内容。正如它看起来的那样奇怪,这段程序并不是一个多线程程序
	 * 。不是一个多线程程序?怎么可能呢?它肯定会生成第二个线程啊。喔,对的,它确实是创建了第二
	 * 个线程,但是它从未启动这个线程。相反地,主线程会调用那个新的线程实例的 run 方法,这个 run 方法会在主线程中同步地运行。
	 * 
	 * @param args
	 */
	public static synchronized void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				pong();
			}
		};
		t.run(); // t.run() 改成 t.start()
		System.out.print("Ping");

		// print: PongPing
		// 当你想调用一个线程的 start 方法时要多加小心,别弄错成调 用这个线程的 run 方法了

	}

	static synchronized void pong() {
		System.out.print("Pong");
	}

}
