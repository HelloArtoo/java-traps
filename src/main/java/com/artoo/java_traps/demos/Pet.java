package com.artoo.java_traps.demos;

public class Pet {

	public final String name;
	public final String food;
	public final String sound;

	public Pet(String name, String food, String sound) {
		this.name = name;
		this.food = food;
		this.sound = sound;
	}

	public void eat() {
		System.out.println(name + ": Mmmmmmm " + food);
	}

	public void play() {
		System.out.println(name + ": " + sound + " " + food);
	}

	public void sleep() { // 改名snooze()
		System.out.println(name + ": Zzzzz... ");
	}

	public void live() {
		new Thread() {
			public void run() {
				while (true) {
					eat();
					play();
					// sleep(); //编译出错
					// snooze();
				}
			}
		}.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Exception in thread "Thread-0" java.lang.Error: Unresolved
		 * compilation problem: The method sleep(long) in the type Thread is not
		 * applicable for the arguments ()
		 * 
		 * at com.artoo.java_traps.demos.Pet$1.run(Pet.java:33)
		 * 
		 * 总之,要小心无意间产生的遮蔽,并且要学会识别表明存在这种情况的编译器错
		 * 误信息。对于编译器的编写者来说,你应该尽力去产生那些对程序员来说有意义
		 * 的错误消息。例如在我们的程序中,编译器应该可以警告程序员,存在着适用于 方法调用但却被遮蔽掉的方法
		 */
		new Pet("Pig", "rice", "GuluGulu...").live();

	}

}
